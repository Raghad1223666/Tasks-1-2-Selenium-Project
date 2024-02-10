package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import support.Constants;

public class addWatchesWithPriceGreaterThan50ToCompareListActions implements Constants {

	public void clickOnGearMenuItem() {
		driver.findElement(By.linkText("Gear")).click();
	}

	public void clickOnWatchesFromList() {
		driver.findElement(By.linkText("Watches")).click();
	}

	public void clickOnListModeButton() {
		driver.findElement(By.id("mode-list")).click();
	}

	public int clickOnAddToCompareListForProductsWithPriceGreaterThan50() {
		List<WebElement> watchesPriceElements = driver.findElements(By.cssSelector(".price-wrapper .price"));
		List<WebElement> compareListButtons = driver.findElements(By.cssSelector("[title=\"Add to Compare\"]"));
		int productQty = 0;
		
		for (int i = 0; i < watchesPriceElements.size(); i++) {
			try {

				Double watchPriceDouble = Double.parseDouble(watchesPriceElements.get(i).getText().replace("$", ""));
				if (watchPriceDouble > 50.00) {
					compareListButtons.get(i).click();
					productQty++;

				}
			} catch (StaleElementReferenceException e) {
				watchesPriceElements = driver.findElements(By.cssSelector(".price-wrapper .price"));
				compareListButtons = driver.findElements(By.cssSelector("[title=\"Add to Compare\"]"));
				i--;

			}
		}
		
		return productQty;
	}

}