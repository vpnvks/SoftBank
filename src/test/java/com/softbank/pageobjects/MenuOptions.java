package com.softbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softbank.utilities.WaitsForElement;

public class MenuOptions {
	
WebDriver localdriver;
	
	public MenuOptions(WebDriver remotedriver) {
	
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	@FindBy(id="logout_sidebar_link")
	WebElement logout;
	
	public void clickOnLogout() {
		WaitsForElement.wait(localdriver, logout).click();
	}
}
