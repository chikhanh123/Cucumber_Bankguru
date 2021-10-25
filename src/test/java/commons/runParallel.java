package commons;

import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class) 
@CucumberOptions(features = {
		"src/test/resources/feature/register.feature",
//		"src/test/resources/feature/AddNewCustomer.feature",
}
						, junit = "--step-notifications"
						, glue = { "commons", "stepDefinition" }
//						, tags = {" @TestBlazeDemo "}
//						, dryRun = true
						, plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json" })
@Test
public class runParallel extends AbstractTestNGCucumberTests {
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