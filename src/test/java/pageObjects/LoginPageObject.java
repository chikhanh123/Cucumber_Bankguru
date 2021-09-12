package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.AbstractPage;
import interfaces.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	@FindBy(xpath = LoginPageUI.login_Form)
	WebElement  login_Form;

	@FindBy(xpath = LoginPageUI.here_Link)
	WebElement  here_Link;
	
	@FindBy(xpath = LoginPageUI.User_Id_Textbox)
	WebElement  User_Id_Textbox;
	
	@FindBy(xpath = LoginPageUI.password_Textbox)
	WebElement  password_Textbox;
	
	@FindBy(xpath = LoginPageUI.Login_Button)
	WebElement  Login_Button;
	
	public LoginPageObject(WebDriver driver) {
		initElement(driver);
	}
	
	public void loginFormDisplayed() {
		waitForElementVisible(login_Form);
		Assert.assertTrue(login_Form.isDisplayed());
	}

	public void clickToHereLink(){
		waitForElementVisible(here_Link);
		clickToElement(here_Link);
	}
	
	public void clickLoginButton(){
		waitForElementVisible(Login_Button);
		clickToElement(Login_Button);
	}
	
	public void inputUsernameAndPassword(String username, String password) {
		waitForElementVisible(User_Id_Textbox);
		waitForElementVisible(password_Textbox);
		sendkeysToElement(User_Id_Textbox, username);
		sendkeysToElement(password_Textbox, password);
	}



}
