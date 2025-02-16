package com.softbank.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softbank.pageobjects.HomePage;
import com.softbank.pageobjects.LoginPage;
import com.softbank.pageobjects.MenuOptions;
import com.softbank.utilities.DataTypeConverter;
import com.softbank.utilities.XLUtility;

public class TC01_SuccessfulUseLogin extends BaseClass{
	
 
  @Test(dataProvider="exceldata")
  public void testUserLogin(Object unmobj, Object pwobj) throws InterruptedException {
	  
	  LoginPage lp = new LoginPage(driver);
	  HomePage hp =new HomePage(driver);
	  MenuOptions mo =new MenuOptions(driver);
	  
	  
	  lp.enterUsername(DataTypeConverter.convertToString(unmobj));
	  lp.enterPassword(DataTypeConverter.convertToString(pwobj));
	  lp.clickOnSubmit();
	  
	  logger.info("login successful");
	 
	  hp.clickOnMenu();
	  mo.clickOnLogout();
	  
	  logger.info("logout successful");
	  
  }
  
  @DataProvider(name="userdata")
  public String[][] usercredential(){
	return new String[][] {{"standard_user","secret_sauce"},{"standard_user","secret_sauce"}};
	  
  }
  
  @DataProvider(name="exceldata")
  public Object[][] userCredDetails(){
	  
	return XLUtility.readExcel("userCredential", "userdetails", 1);
	  
  }
}
