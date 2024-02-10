package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import support.Constants;

public class addProductWithUnavailableQtyToCartAssertions implements Constants {

	public void checkAlertMessageContainValue(String unavailableQtyMsg) throws InterruptedException {

		Assert.assertTrue(driver.findElement(By.cssSelector("[role=\"alert\"]")).getText().contains(unavailableQtyMsg));

	}
	
}
