package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import support.Constants;

public class addWatchesWithPriceGreaterThan50ToCompareListAssertions implements Constants {


	public void checkCompareProductsCounterIsContainValue(int productQty) {
		Assert.assertTrue(driver.findElement(By.cssSelector("[title='Compare Products']")).getText()
				.contains("Compare Products " + productQty + " items"));
		// ********* OR *********
		Assert.assertEquals(driver.findElement(By.cssSelector("[title='Compare Products']")).getText(),
				"Compare Products " + productQty + " items");
	}

}
