package stepdef;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import driverfactory.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.LoginPageFactory;

public class LoginStepDef {
	LoginPageFactory login = PageFactory.initElements(WebDriverFactory.getDriver(), LoginPageFactory.class);

	@Given("User is on login page")
	public void user_is_on_login_page() throws InterruptedException {

		WebDriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
		login.enterUsername(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		login.enterPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		login.clickLogin();
		Thread.sleep(3000);
	}

	@Then("User should navigate to Orange HRM home page")
	public void user_should_navigate_to_orange_hrm_home_page() {

		String expectedURLToNavigate = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualURLNavigated = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertEquals(actualURLNavigated, expectedURLToNavigate);
	}

	@Then("User verifies Forgot password link display")
	public void user_verifies_forgot_password_link_display() {
		Assert.assertTrue(login.isForgotPasswordLinkPresent());
	}

}
