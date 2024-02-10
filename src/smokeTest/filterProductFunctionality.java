package smokeTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.filterProductFunctionalityActions;
import pageObjects.filterProductFunctionalityAssertions;
import pageObjects.sharedActions;

@Listeners
public class filterProductFunctionality extends sharedActions {
	filterProductFunctionalityActions action;
	filterProductFunctionalityAssertions assertion;
	String productName = "Jackets";
	String option = "Product Name";
	int productIndex = 1;

	@BeforeSuite
	public void initData() throws InterruptedException {
		action = new filterProductFunctionalityActions();
		assertion = new filterProductFunctionalityAssertions();

		visitWebsite();
		maximizeBrowser();
		Thread.sleep(2000);
	}

	@Test(description = "filter Product Functionality")
	public void searchFunc() throws InterruptedException {
		extentTest = extentReport.createTest("filter Product Functionality");
		extentTest.log(Status.INFO, "filter Product test functionality start");

		action.clickOnCategory();
		action.clickOnProductLink(productName);
		action.selectProductByItsIndex(productIndex);

		Thread.sleep(2000);
		assertion.checkSelectIsContain(option);
		assertion.checkOutputOfFilterIsSortedByAscendingOrder1();
		assertion.checkOutputOfFilterIsSortedByAscendingOrder2();
	}

	@AfterSuite
	public void afterTest() {
		closeBrowser();
	}
}
