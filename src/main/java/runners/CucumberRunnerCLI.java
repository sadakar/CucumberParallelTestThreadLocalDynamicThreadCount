package runners;

import io.cucumber.core.cli.*;

public class CucumberRunnerCLI {

	public static void main(String[] args) {

		String threadCount = System.getProperty("dataproviderthreadcount", "1");
		Main.run(new String[] { 
				
				"classpath:scenarios", 
				
				"-g", "driverfactory",
				"-g","hooks",
				"-g","pagefactory",
				"-g","runners",
				"-g","stepdef",
				
				"-p","pretty",
				"-p","json:target/cucumber-reports/cucumber.json",
				"-p","html:target/cucumber-reports/cucumber-report.html",
				
				"-m",
				
				"--threads",threadCount
				

		}, Thread.currentThread().getContextClassLoader());
	}
}
