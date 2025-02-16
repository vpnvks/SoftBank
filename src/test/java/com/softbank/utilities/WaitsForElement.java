package com.softbank.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsForElement {
	
	public static WebElement wait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		return webElement;
	}

}
