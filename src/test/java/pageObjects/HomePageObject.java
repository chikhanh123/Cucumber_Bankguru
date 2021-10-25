package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = HomePageUI.New_Customer)
	WebElement  new_Customer;
	
	public void verifyHomePageIsDisplayed() {
		waitForElementVisible(welcome_Message_Text);
		List<WebElement> lst = driver.findElements(By.xpath(HomePageUI.welcome_Message_Text));
		if(lst.size() < 1) {
			Assert.assertEquals("Field is displayed", "Field is not displayed");
		}else {
			Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", welcome_Message_Text.getText());
		}
	}

	public void isClickLogoutButton() {
		waitForElementVisible(logout_Button);
		clickToElement(logout_Button);
		
	}

	public void ClickOkAtAleart() {
		waitForAleartPresence();
		acceptAleart();
	}
	
	public void clickNewCustmerButton() {
		waitForElementVisible(new_Customer);
		clickToElement(new_Customer);
	}
	

}
