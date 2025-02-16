package com.softbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.softbank.utilities.ScrollUtils;
import com.softbank.utilities.WaitsForElement;

public class CheckOutConfirmation {
	
	WebDriver loacalDriver;
	
	public CheckOutConfirmation(WebDriver remoteDriver){
		loacalDriver=remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	@FindBy(id="finish")
	WebElement finish;
	
	public void placeOrder() {
		//ScrollUtils.scrollToElement(loacalDriver, finish);
		WaitsForElement.wait(loacalDriver, finish).click();
	}

}
