package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import support.Constants;

public class searchFunctinalityActions implements Constants {

	public void printPageTitle() {
		WebElement element = driver.findElement(By.className("page-title"));
		System.out.println(element.getText());
	}
}
