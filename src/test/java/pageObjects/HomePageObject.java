package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.AbstractPage;
import interfaces.HomePageUI;

public class HomePageObject extends AbstractPage {
	public HomePageObject(WebDriver driver) {
		initElement(driver);
	}


	@FindBy(xpath = HomePageUI.welcome_Message_Text)
	WebElement  welcome_Message_Text;
	
	@FindBy(xpath = HomePageUI.logout_Button)
	WebElement  logout_Button;
	
	public void verifyHomePageIsDisplayed() {
		waitForElementVisible(welcome_Message_Text);
		Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", welcome_Message_Text.getText());
	}

	public void isClickLogoutButton() {
		waitForElementVisible(logout_Button);
		clickToElement(logout_Button);
		
	}

	public void ClickOkAtAleart() {
		waitForAleartPresence();
		acceptAleart();
	}

}
