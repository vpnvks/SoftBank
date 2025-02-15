package com.softbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver localdriver;
	
	public HomePage(WebDriver remotedriver) {
	
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menuIcon;
	
	public void clickOnMenu() {
		menuIcon.click();
	}
	
}
