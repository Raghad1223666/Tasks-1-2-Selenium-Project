package smokeTest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.sharedActions;

public class printNameOfEvenProducts extends sharedActions {

	@BeforeTest
	public void initData() {
		visitWebsite();
		maximizeBrowser();
	}

	@Test(description = "Print the name of the even product in hor seller section")
	public void printNameOfEvenProductsInHotSellerSection() {
		List<WebElement> products = driver.findElements(By.className("product-item-link"));
		for (int i = 0; i < products.size(); i++) {
			if (i % 2 == 0) {
				System.out.println(products.get(i).getText());
			}
		}
	}

	@AfterTest
	public void afterTest() {
		closeBrowser();
	}
}
