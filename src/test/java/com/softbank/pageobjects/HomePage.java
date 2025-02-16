package com.softbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softbank.utilities.WaitsForElement;

public class HomePage {

	WebDriver localdriver;
	
	public HomePage(WebDriver remotedriver) {
	
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menuIcon;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement product1;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement product2;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cart; 
	
	
	public void clickOnMenu() {
		WaitsForElement.wait(localdriver, menuIcon).click();
	}
	
	public void addBackpack() {
		WaitsForElement.wait(localdriver, product1).click();
	}
	public void addBikeLight() {
		product2.click();
	}
	public void viewCart() {
		cart.click();
	}
}
