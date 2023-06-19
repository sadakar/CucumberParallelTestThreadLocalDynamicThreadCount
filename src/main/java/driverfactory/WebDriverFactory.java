package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public final class WebDriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver() {

		String browser = System.getProperty("browser", "chrome");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver.set(new ChromeDriver(options));
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\Drivers\\msedgedriver.exe");
			driver.set(new EdgeDriver());
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void closeDriver() {
		driver.get().quit();
		driver.remove();
	}

}
