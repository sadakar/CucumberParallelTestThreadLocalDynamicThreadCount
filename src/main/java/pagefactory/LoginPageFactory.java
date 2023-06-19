package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory {

	public WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	// Username locator
	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;

	// Password locator
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passWord;

	// Login button locator
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;

	// Forgot password locator
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	public WebElement forgotPassword;
	

	// Method that performs Username action
	public void enterUsername(String uname) {
		userName.sendKeys(uname);
	}

	// Method that performs Password action
	public void enterPassword(String pwd) {
		passWord.sendKeys(pwd);
	}

	// Method that performs Login action
	public void clickLogin() {
		loginButton.click();
	}

	// Method that performs Forgot Password link verification
	public boolean isForgotPasswordLinkPresent() {
		return forgotPassword.isDisplayed();
	}

}
