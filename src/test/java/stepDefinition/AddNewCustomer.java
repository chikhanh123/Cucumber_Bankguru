package stepDefinition;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import pageObjects.AddCustomerPageObject;
import pageObjects.HomePageObject;

public class AddNewCustomer{
	WebDriver driver;
	HomePageObject homePageObject;
	AddCustomerPageObject addCustomerPageObject;
	public AddNewCustomer()  {
		driver = new AbstractTest().getDriver();
		homePageObject = new HomePageObject(driver);
		addCustomerPageObject = new AddCustomerPageObject(driver);
	}
	
	@Then  ("I click New Customer button at Home Page")
	public void i_Click_New_Customer_Button_At_Home_Page() {
		System.out.println("I click New Customer button at Home Page");
		homePageObject.clickNewCustmerButton();
	}
	
	@Then  ("I verify Add New Customer screen is displayed")
	public void i_Verify_Add_New_Customer_Screen_Is_Displayed() {
		System.out.println("I verify Add New Customer screen is displayed");
		addCustomerPageObject.verifyAddCustomerPageIsDisplayed();
	}
	
	@Then  ("I verify error message {string} is displayed when {string} field is blank at Add New Customer")
	public void i_Verify_Error_Msg_Is_Display_When_Field_Is_Blank_At_Add_New_Customer(String msg, String fieldName) {
		System.out.println("I verify error message " +msg+ "is displayed when "+fieldName+"field is blank at Add New Customer");
		addCustomerPageObject.verifyMsgWhenFieldIsBlankAtAddNewCustomer(msg, fieldName);
	}
	
	@Then  ("I click submit button")
	public void i_Click_Submit_Button() {
		System.out.println("I click submit button");
		addCustomerPageObject.clickSubmitButton();
	}
	
	@Then  ("I verify content Aleart {string} is displayed")
	public void i_Verify_Content_Aleart_At_Add_New_Customer(String msg) {
		System.out.println("I verify content Aleart "+ msg + "is displayed");
		addCustomerPageObject.verifyMsgIsDisPlayed(msg);
	}
	
	
}
