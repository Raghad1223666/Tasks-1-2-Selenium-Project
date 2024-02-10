package smokeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pageObjects.searchFunctinalityActions;
import pageObjects.searchFunctinalityAssertions;
import pageObjects.sharedActions;

@Listeners
public class searchFunctionality extends sharedActions {
	String productName = "Bag";
	String title = "Search results for: " + "'" + productName + "'";

	searchFunctinalityAssertions assertion;
	searchFunctinalityActions action;

	@BeforeSuite
	public void initData() throws InterruptedException {
		assertion = new searchFunctinalityAssertions();
		action = new searchFunctinalityActions();

		visitWebsite();
		maximizeBrowser();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
	}

	@Test(description = "Search Functionality")
	public void searchFunc() throws InterruptedException {
		extentTest = extentReport.createTest("Search Functionality Functionality");
		extentTest.log(Status.INFO, "Search Functionality test functionality start");

		typeInSearchInputField(productName);
		action.printPageTitle();

		Thread.sleep(2000);
		assertion.checkPageTitleIsContain(title);
	}

	@AfterSuite
	public void afterTest() {
		closeBrowser();
	}
}
