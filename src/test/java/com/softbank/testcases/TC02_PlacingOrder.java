package com.softbank.testcases;

import org.testng.annotations.Test;

import com.softbank.pageobjects.CheckOutConfirmation;
import com.softbank.pageobjects.DeliveryAddress;
import com.softbank.pageobjects.HomePage;
import com.softbank.pageobjects.LoginPage;
import com.softbank.pageobjects.ShoppingCart;

public class TC02_PlacingOrder extends BaseClass{
	
	@Test
	public void placeOrder() throws InterruptedException {
	
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ShoppingCart sc = new ShoppingCart(driver);
		DeliveryAddress da = new DeliveryAddress(driver);
		CheckOutConfirmation coc = new CheckOutConfirmation(driver);
		
		lp.enterUsername("standard_user");
		lp.enterPassword("secret_sauce");
		lp.clickOnSubmit();
		logger.info("loged-in to the homepage");
		hp.addBackpack();
		hp.addBikeLight();
		logger.info("added items to the cart");
		hp.viewCart();
		logger.info("open cart");
		sc.checkoutCart();
		logger.info("checked-out the cart");
		Thread.sleep(3000);
		da.enterName("vipin");
		da.enterSurName("mishra");
		da.enterZipCode("456787");
		da.clickOnContinue();
		Thread.sleep(3000);
		logger.info("checked-out the cart");
		coc.placeOrder();
		Thread.sleep(3000);
	}

}
