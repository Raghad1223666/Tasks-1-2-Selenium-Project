package pageObjects;

import org.openqa.selenium.By;
import support.Constants;

public class loginPageActions implements Constants {
	
	public void clickOnSignInLink() {
		// driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(By.className("not-logged-in"))).click();
		driver.findElement(By.linkText("Sign In")).click();
	}

	public void typeInEmailInputField() {
//		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.cssSelector(".email .label"))).sendKeys(email);
		driver.findElement(By.name("login[username]")).sendKeys(email);
	}

	public void typeInPasswordInputField() {
		// driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.cssSelector(".password
		// .label"))).sendKeys(password);
		driver.findElement(By.name("login[password]")).sendKeys(password);
	}

	public void clickOnSignInButton() {
		// driver.findElement(RelativeLocator.with(By.tagName("button")).toLeftOf(By.cssSelector(".action.remind"))).click();
		driver.findElement(By.id("send2")).click();

	}
}
