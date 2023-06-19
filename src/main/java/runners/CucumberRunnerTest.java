package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "classpath:scenarios", 
		tags = "@Login or @ForgotPassword", 
		glue = { "driverfactory", "hooks",
				"pagefactory", "runners", "stepdef" }, 
		plugin = { "pretty","json:target/cucumber-reports/cucumber.json",
						"html:target/cucumber-reports/cucucmber-report.html" }, 
		monochrome = true)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
