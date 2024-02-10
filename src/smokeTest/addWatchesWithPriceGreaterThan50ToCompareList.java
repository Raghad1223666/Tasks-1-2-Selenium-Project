package smokeTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.addWatchesWithPriceGreaterThan50ToCompareListActions;
import pageObjects.addWatchesWithPriceGreaterThan50ToCompareListAssertions;
import pageObjects.sharedActions;

public class addWatchesWithPriceGreaterThan50ToCompareList extends sharedActions {
	addWatchesWithPriceGreaterThan50ToCompareListAssertions assertion;
	addWatchesWithPriceGreaterThan50ToCompareListActions action;


	@BeforeTest
	public void initData() {
		assertion = new addWatchesWithPriceGreaterThan50ToCompareListAssertions();
		action = new addWatchesWithPriceGreaterThan50ToCompareListActions();
		
		visitWebsite();
		maximizeBrowser();
	}

	@Test(description = "Add all watches with price > 50 to compare list")
	public void addWatchesWithPriceGreaterThan50ToTheCompareList() throws InterruptedException {
		action.clickOnGearMenuItem();
		action.clickOnWatchesFromList();
		action.clickOnListModeButton();
		int productQty = action.clickOnAddToCompareListForProductsWithPriceGreaterThan50();
		
		Thread.sleep(3000);
		assertion.checkCompareProductsCounterIsContainValue(productQty);
	}

	@AfterTest
	public void afterTest() {
		closeBrowser();
	}

}
