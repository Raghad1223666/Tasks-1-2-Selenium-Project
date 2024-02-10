package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import support.Constants;

public class searchFunctinalityAssertions implements Constants {

	public void checkPageTitleIsContain(String title) {
		Assert.assertEquals(driver.findElement(By.className("page-title")).getText(), title);
	}
}
