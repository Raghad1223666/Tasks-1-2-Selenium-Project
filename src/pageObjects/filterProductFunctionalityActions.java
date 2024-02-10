package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import support.Constants;

public class filterProductFunctionalityActions implements Constants {

	public void clickOnCategory() {
		driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]")).click();
	}

	public void clickOnProductLink(String productName) {
		driver.findElement(By.linkText(productName)).click();
	}

	public void selectProductByItsIndex(int productIndex) {
		WebElement sorterElement = driver.findElement(By.id("sorter"));
		Select dropDown = new Select(sorterElement);
		dropDown.selectByIndex(productIndex);
	}
}
