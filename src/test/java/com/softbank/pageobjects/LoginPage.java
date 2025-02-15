package com.softbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver localdriver;
	public LoginPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(name="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	public void enterUsername(String unm) {
		username.sendKeys(unm);
	}
	
	public void enterPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickOnSubmit() {
		loginbutton.click();
	}
}
