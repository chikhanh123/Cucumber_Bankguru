package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		List<WebElement> lst = driver.findElements(By.xpath(RegisterPageUI.email_Textbox));
		if (lst.size() < 1) {
			Assert.assertEquals("Register page is displayed", "Register page is not displayed");
		} else {
			Assert.assertEquals("Register page is displayed", "Register page is displayed");
		}
	}

	public void inputToEmailIdtextbox(String email) {
		sendkeysToElement(email_Textbox, email);
	}

	public void clickToLoginButton() {
		waitForElementVisible(submit_Button);
		clickToElement(submit_Button);
	}

	public void verifyUserNameAndPassWordIsDisplayed() {
		List<WebElement> lst = driver.findElements(By.xpath(RegisterPageUI.user_Id_Infor));
		if (lst.size() < 1) {
			Assert.assertEquals("user id is displayed", "user id is not displayed");
		} else {
			Assert.assertEquals("user id is displayed", "user id is displayed");

		}
		lst = driver.findElements(By.xpath(RegisterPageUI.password_Infor));
		if (lst.size() < 1) {
			Assert.assertEquals("password is displayed", "password is not displayed");
		} else {
			Assert.assertEquals("password is displayed", "password is displayed");
		}
	}

}
