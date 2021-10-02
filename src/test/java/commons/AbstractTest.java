package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LoginPageObject;

public class AbstractTest {
	public static WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	PageManager pageManager = new PageManager();
	
	public WebDriver openMultiBrowser() {
		PageManager.funcReadPropertiesFile("src/main/resources/browser.properties");
		String browserName = System.getProperty("browser");
		if (browserName.trim().equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/dxcv/eclipse-workspace/POM_BANKGURU/resources/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.trim().equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/dxcv/eclipse-workspace/POM_BANKGURU/resources/geckodriver");
			driver = new FirefoxDriver();
		}
		return driver;

	}
	
//	public void initPages() throws IllegalArgumentException, IllegalAccessException, InstantiationException, SecurityException {
//		List <AbstractPage> pages = new ArrayList<AbstractPage>();
//		Field[] fields = getClass().getDeclaredFields();
//		for(Field field:fields) {
//			Class<?> fieldType = field.getType();
//			if(AbstractPage.class.isAssignableFrom(fieldType)) {
//				field.setAccessible(true);
//				AbstractPage abstractPage = (AbstractPage) field.get(this);
//				if(abstractPage == null) {
//					try {
//						abstractPage = (AbstractPage) fieldType.getDeclaredConstructor().newInstance();
//					}catch(InvocationTargetException | NoSuchMethodException e)
//					{
//						e.printStackTrace();
//					}
//					field.set(this, abstractPage);
//				}
//				field.setAccessible(false);
//				pages.add(abstractPage);
//			}
//		}
//		pages.forEach(page->page.initElement(driver));
//	}
//	
	
	
	@Before
	public void beforeTest () throws IllegalArgumentException, IllegalAccessException, InstantiationException, SecurityException {
		 driver = openMultiBrowser();
		 driver.manage().window().maximize();
//		 initPages();
		 driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Given("Open Url")
	public void openUrl() {
		driver.get(Constants.ULR);
	}
	
	
	@After
	public void afterTest() {
		driver.quit();
	}
}
