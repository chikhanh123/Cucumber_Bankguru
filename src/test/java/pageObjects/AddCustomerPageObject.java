package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.AbstractPage;
import interfaces.AddCustomerPageUI;
import org.junit.Assert;

public class AddCustomerPageObject extends AbstractPage {
	public AddCustomerPageObject(WebDriver driver) {
		initElement(driver);
	}


	@FindBy(xpath = AddCustomerPageUI.add_New_Customer_lbl)
	WebElement add_New_Customer_lbl;
	@FindBy(xpath = AddCustomerPageUI.customer_Name_txt)
	WebElement customer_Name_txt;
	@FindBy(xpath = AddCustomerPageUI.male_btn)
	WebElement male_btn;
	@FindBy(xpath = AddCustomerPageUI.female_btn)
	WebElement female_btn;
	@FindBy(xpath = AddCustomerPageUI.dOB_txt)
	WebElement dOB_txt;
	@FindBy(xpath = AddCustomerPageUI.address_txt)
	WebElement address_txt;
	@FindBy(xpath = AddCustomerPageUI.city_txt)
	WebElement city_txt;
	@FindBy(xpath = AddCustomerPageUI.state_txt)
	WebElement state_txt;
	@FindBy(xpath = AddCustomerPageUI.pin_txt)
	WebElement pin_txt;
	@FindBy(xpath = AddCustomerPageUI.mobile_Number_txt)
	WebElement mobile_Number_txt;
	@FindBy(xpath = AddCustomerPageUI.email_txt)
	WebElement email_txt;
	@FindBy(xpath = AddCustomerPageUI.password_txt)
	WebElement password_txt;
	@FindBy(xpath = AddCustomerPageUI.submit_btn)
	WebElement submit_btn;
	@FindBy(xpath = "//label[text()='Customer name must not be blank']")
	WebElement customer_Name_msg;
	@FindBy(xpath = "//label[text()='Date Field must not be blank']")
	WebElement dob_msg;
	@FindBy(xpath = "//label[text()='Address Field must not be blank']")
	WebElement address_msg;
	@FindBy(xpath = "//label[text()='City Field must not be blank']")
	WebElement city_msg;
	@FindBy(xpath = "//label[text()='State must not be blank']")
	WebElement state_msg;
	@FindBy(xpath = "//label[text()='PIN Code must not be blank']")
	WebElement pin_msg;
	@FindBy(xpath = "//label[text()='Mobile no must not be blank']")
	WebElement mobile_msg;
	@FindBy(xpath = "//label[text()='Email-ID must not be blank']")
	WebElement emailID_msg;
	@FindBy(xpath = "//label[text()='Password must not be blank']")
	WebElement password_msg;
	
	
	public void verifyAddCustomerPageIsDisplayed() {
		waitForElementVisible(add_New_Customer_lbl);
		Assert.assertEquals("Add New Customer", add_New_Customer_lbl.getText());
	}
	
	public void verifyMsgWhenFieldIsBlankAtAddNewCustomer(String msg, String fieldname) {
		if(fieldname.trim().equals("Customer Name")) {
			waitForElementVisible(customer_Name_txt);
			clickToElement(customer_Name_txt);
			clickToElement(submit_btn);
			Assert.assertEquals(msg, customer_Name_msg.getText());
		} else if(fieldname.trim().equals("Date of Birth")) {
			waitForElementVisible(dOB_txt);
			clickToElement(dOB_txt);
			clickToElement(submit_btn);
			Assert.assertEquals(msg, dob_msg.getText());
		} else if(fieldname.trim().equals("Address")) {
			waitForElementVisible(address_txt);
			clickToElement(address_txt);
			clickToElement(submit_btn);
			Assert.assertEquals(msg, address_msg.getText());
		} else if(fieldname.trim().equals("City")) {
			waitForElementVisible(city_txt);
			clickToElement(city_txt);
			clickToElement(submit_btn);
			Assert.assertEquals(msg, city_msg.getText());
		} else if(fieldname.trim().equals("State")) {
			waitForElementVisible(state_txt);
			clickToElement(state_txt);
			clickToElement(submit_btn);
			Assert.assertEquals(msg, state_msg.getText());
		} else if(fieldname.trim().equals("PIN")) {
			
		}


	}
	
	


}
