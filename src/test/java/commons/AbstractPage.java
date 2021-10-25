package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
//	ham dung chung page
	JavascriptExecutor javascriptExecutor;
	WebDriverWait waitExplicit;
	Actions action;
	public WebDriver driver;
	long longTimeOut = 30;
	String browserName = System.getProperty("browser");

	public void openUrl(String ulr) {
		driver.get(ulr);
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageSource() {
		return driver.getTitle();
	}

	public void backToPreviousPage() {
		driver.navigate().back();
	}

	public void refershCurrentPage() {
		driver.navigate().refresh();
	}

	public void forwardToNextPage() {
		driver.navigate().forward();
	}

	public void acceptAleart() {
		driver.switchTo().alert().accept();
	}

	public void cancelAleart() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextInAleart() {
		return driver.switchTo().alert().getText();
	}

	public void sendkeysToAleart(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void clickToElement(WebElement element) {
		waitForElementClickable(element);
		if (browserName.equalsIgnoreCase("safari")) {
			clickToElementByJS(element);
		} else {
			element.click();
		}
	}

	public void sendkeysToElement(WebElement element, String vakue) {
		element.sendKeys(vakue);
	}

	public String getTextElement(WebElement element) {
		return element.getText();
	}

	public void selectItemInDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public String getValueItemSelected(WebElement element, String value) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void Select_Item_Dropdownlist(String parentxpath, String allItemXpath, String ItemValue) throws Exception {
//		  click vao dropdown de show ra item
		javascriptExecutor = (JavascriptExecutor) driver;
//		  sử dụng khi nút cần click không hiển thị trên màn hình phải kéo xuống mới thấy
		javascriptExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(parentxpath)));
//		  driver.findElement(By.xpath(parentXpath)).click();

//		  đợi all webelement LstAllItem is load trong 30
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		List<WebElement> LstAllItem = driver.findElements(By.xpath(allItemXpath));
//		  đợi cho 1 element xuất 
//		  waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ItemXpathValue)));
//			Tạo Webelement Item cho chạy hết tuần tự trong cái List Webelement LstAllItem.
		for (WebElement Item : LstAllItem) {
			if (Item.getText().equals(ItemValue)) {
//				  scroll đến cái xpath chưá value là: ItemValue
				javascriptExecutor = (JavascriptExecutor) driver;
				javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", Item);
				Thread.sleep(1500);
//				  click vao item can chon
				Item.click();
//				  neu xpath Item khong visibal thi su dung ham click javascrips
				break;
			}
		}
	}

	public String getAttributeValue(WebElement element, String attributeValue) {
		return element.getAttribute(attributeValue);
	}

	public int countElementNumber(List<WebElement> elements) {
		return elements.size();
	}

	public void checkToCheckBox(WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckBox(WebElement element) {
		if (element.isSelected()) {
			element.click();
		}
	}

	public void switchToChildWindowUseTitle(String desTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			if (driver.getTitle().equals(desTitle)) {
				break;
			}
		}
	}

	public Boolean closeAllWindowsExceptParentWindow(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToIframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void backToTopWindows() {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void clickToElementByJS(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}

	public void sendkeysToElementByJS(WebElement element, String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	public void waitForElementPreSence(String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		By bylocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(bylocator));
	}

	public WebElement waitForElementVisible(WebElement element) {
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		return waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebElement element) {
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementInvisible(WebElement element) {
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForAleartPresence() {
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void initElement(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
}