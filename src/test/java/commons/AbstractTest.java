package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

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
					"C:\\Users\\Neolab\\eclipse-workspace\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.trim().equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/dxcv/eclipse-workspace/POM_BANKGURU/resources/geckodriver");
			driver = new FirefoxDriver();
		} else if(browserName.trim().equals("Safari")) {
			driver = new SafariDriver();
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
