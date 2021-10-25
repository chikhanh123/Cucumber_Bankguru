package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commons.AbstractPage;
import interfaces.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	@FindBy(xpath = RegisterPageUI.email_Textbox)
	WebElement email_Textbox;

	@FindBy(xpath = RegisterPageUI.submit_Button)
	WebElement submit_Button;

	@FindBy(xpath = RegisterPageUI.user_Id_Infor)
	WebElement user_Id_Infor;

	@FindBy(xpath = RegisterPageUI.password_Infor)
	WebElement password_Infor;

	public RegisterPageObject(WebDriver driver) {
		initElement(driver);
	}

	public void registerPageDisplayed() {
		waitForElementVisible(email_Textbox);
		Assert.assertTrue(email_Textbox.isDisplayed(), "Email textbox is not displayed");
	}

	public void inputToEmailIdtextbox(String email) {
		sendkeysToElement(email_Textbox, email);
	}

	public void clickToLoginButton() {
		clickToElement(submit_Button);
	}

	public void verifyUserNameAndPassWordIsDisplayed() {
		try {
			Assert.assertTrue(user_Id_Infor.isDisplayed(), "User ID is not displayed");
			Assert.assertTrue(password_Infor.isDisplayed(), "User ID is not displayed");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
