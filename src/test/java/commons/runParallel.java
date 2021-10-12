package commons;

import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; 
//import io.cucumber.testng.CucumberOptions;



@RunWith(Cucumber.class) 
@CucumberOptions(features = {
//		"src/test/resources/feature/register.feature",
		"src/test/resources/feature/AddNewCustomer.feature",
}
						, glue = { "commons", "stepDefinition" }
//						, tags = {" @TestBlazeDemo "}
//						, dryRun = true
						, plugin = { "pretty", "html:target/cucumber-html-", "json:target/cucumber.json" })
@Test
public class runParallel extends io.cucumber.testng.AbstractTestNGCucumberTests {
	@BeforeClass
	public void setupClassName(ITestContext context) {
		PageManager.funcReadPropertiesFile("src/main/resources/config.properties");
		
	 	context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(System.getProperty("parallelThreadCount").trim()));
		context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}