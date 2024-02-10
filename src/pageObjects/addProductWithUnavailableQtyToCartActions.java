package pageObjects;

import org.openqa.selenium.By;

import support.Constants;

public class addProductWithUnavailableQtyToCartActions implements Constants {

	public void selectFirstProduct() {
		driver.findElement(By.cssSelector(".product-items .product-item:nth-child(1)")).click();
	}

	public void clickOnAddToCartButton() {
		driver.findElement(By.cssSelector("[title=\"Add to Cart\"]")).click();
	}
	
}
