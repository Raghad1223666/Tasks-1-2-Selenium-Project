package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import support.Constants;
import support.extentReportClass;

public class sharedActions extends extentReportClass implements Constants {

	public void visitWebsite() {
//		RelativeLocator.with(By.tagNamr("")).below(By.);
		driver.get("https://magento.softwaretestingboard.com/");
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void typeInSearchInputField(String product) {
		driver.findElement(By.id("search")).sendKeys(product + Keys.ENTER);

	}

	public void closeBrowser() {
		driver.close();
	}
}
