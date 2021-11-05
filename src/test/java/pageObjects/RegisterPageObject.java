package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commons.AbstractPage;
import commons.PageManager;
import interfaces.RegisterPageUI;


public class RegisterPageObject extends AbstractPage {
	
	PageManager pageManager = new PageManager();
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

	public void inputToEmailIdtextbox(String email) throws IOException {
		String data[] =pageManager.readExcelFileReturnArray("C:\\Users\\Neolab\\Desktop","New Microsoft Excel Worksheet.xlsx","Sheet1");
		sendkeysToElement(email_Textbox, email);
	}

	public void clickToLoginButton() {
		clickToElement(submit_Button);
	}

	public void verifyUserNameAndPassWordIsDisplayed() throws IOException {
			Assert.assertTrue(user_Id_Infor.isDisplayed(), "User ID is not displayed");
			Assert.assertTrue(password_Infor.isDisplayed(), "User ID is not displayed");
	}
}
