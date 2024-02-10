package smokeTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.addProductWithUnavailableQtyToCartActions;
import pageObjects.addProductWithUnavailableQtyToCartAssertions;
import pageObjects.sharedActions;

public class addProductWithUnavailableQtyToCart extends sharedActions {
	String unavailableQtyMsg = "The requested qty is not available";

	addProductWithUnavailableQtyToCartActions action ;
	addProductWithUnavailableQtyToCartAssertions assertion;
	
	@BeforeTest
	public void initData() {
		action = new addProductWithUnavailableQtyToCartActions();
		assertion = new addProductWithUnavailableQtyToCartAssertions();
		
		visitWebsite();
		maximizeBrowser();
		
	}

	@Test(description = "Add product with unavailable qty to cart")
	public void addProductWithUnavailableQty() throws InterruptedException {
		typeInSearchInputField("Push It Messenger Bag");
		action.selectFirstProduct();
		action.clickOnAddToCartButton();
		
		Thread.sleep(3000);
		assertion.checkAlertMessageContainValue(unavailableQtyMsg);
	}

	@AfterTest
	public void afterTest() {
		closeBrowser();
	}
}
