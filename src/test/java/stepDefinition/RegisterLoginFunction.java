package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class RegisterLoginFunction{
	WebDriver driver;
	LoginPageObject loginPageObject;
	RegisterPageObject registerPageObject;
	HomePageObject homePageObject;
	public RegisterLoginFunction() {
		driver = new AbstractTest().getDriver();
		loginPageObject = new LoginPageObject(driver);
		registerPageObject = new RegisterPageObject(driver);
		homePageObject = new HomePageObject(driver);
	}
	
	@Then  ("I verify login page is displayed")
	public void I_verify_login_page_is_displayed() {
		System.out.println("I verify login page is displayed");
		loginPageObject.loginFormDisplayed();
	}
	
	@Then  ("I click here link at login page")
	public void I_click_here_link_at_login_page() {
		System.out.println("I click here link at login page");
		loginPageObject.clickToHereLink();
	}
	
	@Then("I verify register page is displayed")
	public void I_verify_register_page_is_displayed() {
		System.out.println("I verify register page is displayed");
		registerPageObject.registerPageDisplayed();
	}
	
	@Then("I input email {string} at register page")
	public void I_input_email_at_register_page(String email) throws IOException {
		System.out.println("I input email at register page");
		registerPageObject.inputToEmailIdtextbox(email);
	}
	
	@Then("I click submit button at register page")
	public void i_click_submit_button_at_register_page() {
		System.out.println("I click submit button at register page");
		registerPageObject.clickToLoginButton();
	}
	
	@Then("I verify username and password is displayed")
	public void i_verify_username_and_password_is_displayed() throws IOException {
		System.out.println("I verify username and password is displayed");
		registerPageObject.verifyUserNameAndPassWordIsDisplayed();
	}
	
	@Then("I click login button")
	public void i_click_login_button() {
		System.out.println("I click login button");
		loginPageObject.clickLoginButton();
	}
	
	@Then("I verify home page is displayed")
	public void i_verify_home_page_is_displayed() {
		System.out.println("I verify home page is displayed");
		homePageObject.verifyHomePageIsDisplayed();
	}
	
	@Then("I click logout button")
	public void i_click_logout_button() {
		System.out.println("I click logout button");
		homePageObject.isClickLogoutButton();
	}
	
	@Then("I click ok at Aleart")
	public void i_click_ok_at_Aleart() {
		System.out.println("I click ok at Aleart");
		homePageObject.ClickOkAtAleart();
	}
	
	@Then("I input username {string} and password {string}")
	public void i_input_username_and_password(String username, String password) {
		System.out.println("I input username and password");
		loginPageObject.inputUsernameAndPassword(username,password);
	}
}
