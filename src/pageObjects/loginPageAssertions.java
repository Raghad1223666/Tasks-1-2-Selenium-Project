package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import support.Constants;

public class loginPageAssertions implements Constants {
	
	public void checkCurrentUrlIsContain(String currentUrl) {
		Assert.assertEquals(driver.getCurrentUrl(), currentUrl);
	}

	public void checkHeaderIsContain(String message) {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText(),
				message);
	}
}
