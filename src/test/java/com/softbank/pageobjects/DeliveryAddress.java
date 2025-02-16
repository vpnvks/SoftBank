package com.softbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softbank.utilities.ScrollUtils;
import com.softbank.utilities.WaitsForElement;

public class DeliveryAddress {
	
WebDriver localDriver;
	
	public DeliveryAddress(WebDriver remoteDriver){
		localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

	@FindBy(id="first-name")
	WebElement name;
	
	@FindBy(id="last-name")
	WebElement surName;
	
	@FindBy(id="postal-code")
	WebElement zipCode;
	
	@FindBy(id="continue")
	WebElement proceed;
	
	public void enterName(String firstName) {
		WaitsForElement.wait(localDriver, name).sendKeys(firstName);
	}
	
	public void enterSurName(String lastName) {
		surName.sendKeys(lastName);
	}
	
	public void enterZipCode(String postCode) {
		zipCode.sendKeys(postCode);
	}
	
	public void clickOnContinue() {
		ScrollUtils.scrollToElement(localDriver, proceed);
		proceed.click();
	}
	
}
