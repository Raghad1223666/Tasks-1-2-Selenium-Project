package smokeTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import pageObjects.loginPageActions;
import pageObjects.loginPageAssertions;
import pageObjects.sharedActions;

@Listeners
public class loginPage extends sharedActions {
	loginPageAssertions assertion;
	loginPageActions action;
	String currentUrl = "https://magento.softwaretestingboard.com/";
	String message = "Welcome, cypress user!";

	@BeforeSuite
	public void initData() {
		assertion = new loginPageAssertions();
		action = new loginPageActions();
		visitWebsite();
		maximizeBrowser();
	}

	@Test(description = "Login functionality")
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		extentTest = extentReport.createTest("Login functionality");
		extentTest.log(Status.INFO, "Login test functionality start");

		action.clickOnSignInLink();
		action.typeInEmailInputField();
		action.typeInPasswordInputField();
		action.clickOnSignInButton();

		assertion.checkCurrentUrlIsContain(currentUrl);
		Thread.sleep(2000);
		assertion.checkHeaderIsContain(message);

	}

	@AfterSuite
	public void afterTest() {
		closeBrowser();
	}
}
