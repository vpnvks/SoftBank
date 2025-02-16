package com.softbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softbank.utilities.WaitsForElement;

public class ShoppingCart {
	WebDriver localDriver;
	
	public ShoppingCart(WebDriver remoteDriver){
		localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

	@FindBy(id="checkout")
	WebElement checkout;
	
	public void checkoutCart() {
		WaitsForElement.wait(localDriver, checkout).click();
	}
}
