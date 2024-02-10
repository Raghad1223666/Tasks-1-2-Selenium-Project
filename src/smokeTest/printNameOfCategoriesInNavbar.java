package smokeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.sharedActions;

public class printNameOfCategoriesInNavbar extends sharedActions {

	@BeforeTest
	public void initData() {
		visitWebsite();
		maximizeBrowser();
	}

	@Test(description = "Print name of the Categories in the navbar")
	public void printNameOfTheCategoriesInTheNavbar() {
		List<WebElement> products = driver.findElements(By.cssSelector("li.level0"));
		for (WebElement product : products) {
			System.out.println(product.getText());
		}
	}

	@AfterTest
	public void afterTest() {
		closeBrowser();
	}
}
