package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import support.Constants;

public class filterProductFunctionalityAssertions implements Constants {

	public void checkSelectIsContain(String selectOption) {
		Select select = new Select(driver.findElement(By.id("sorter")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		Assert.assertEquals(defaultItem, selectOption);
	}

	public void checkOutputOfFilterIsSortedByAscendingOrder1() {
		List<WebElement> products = driver.findElements(By.cssSelector(".item.product-item"));

		char firstProductChar = products.get(0).findElement(By.className("product-item-link")).getText().charAt(0);
		char lastProductChar = products.get(products.size() - 1).findElement(By.className("product-item-link"))
				.getText().charAt(0);

		if (firstProductChar < lastProductChar) {
			System.out.println("The first character is less than the second character.");
			Assert.assertTrue(firstProductChar < lastProductChar,
					"The first character is not less than the second character.");

		} else if (firstProductChar == lastProductChar) {
			System.out.println("The first and second characters are equal, please check the fist 2 chars");
			Assert.fail("Test failed because a specific condition is not met.");

		} else {
			System.out.println("The first character is greater than the second character.");
			Assert.fail("Test failed because a specific condition is not met.");
		}

	}

	public void checkOutputOfFilterIsSortedByAscendingOrder2() {
		List<WebElement> productsNameElements = driver.findElements(By.cssSelector(".product-item-link"));
		List<String> productsNameTexts = new ArrayList<String>(productsNameElements.size());

		for (WebElement productElement : productsNameElements) {
			String productText = productElement.getText();
			productsNameTexts.add(productText);
		}

		System.out.println("productsNameTexts Before Apply sort" + productsNameTexts);

		List<String> sortedProductsNameText = new ArrayList<String>(productsNameTexts);
		Collections.sort(sortedProductsNameText);

		System.out.println("sortedProductsNameText After Apply sort" + sortedProductsNameText);

		Assert.assertEquals(productsNameTexts, sortedProductsNameText);
	}

}
