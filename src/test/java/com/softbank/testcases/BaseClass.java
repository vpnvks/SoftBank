package com.softbank.testcases;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

import com.softbank.utilities.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static PropertyReader pr = new PropertyReader();
	public static String url=pr.geturl();
	public static WebDriver driver;
	public static Logger logger;
 
@Parameters("browser")
  @BeforeClass
  public void Setup(String br) {
	
	System.out.println("inse the base");
	if(br.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(br.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if(br.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	else if(br.equalsIgnoreCase("safari")) {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
		}
	else {
	 System.out.println("Browser is not define");
	}
	
	
	driver.get(url);
	driver.manage().window().maximize();
	
	logger = Logger.getLogger("SoftBank");
	PropertyConfigurator.configure("./configuration/log4j.properties");
	logger.info("browaser launched and url is open");
  }

  @AfterClass
  public void tearDown(ITestContext context) {
	 
	  driver.quit();
	  for (ITestNGMethod method : context.getAllTestMethods()) {
		  String testClassName = method.getRealClass().getSimpleName();
		  String testMethodName = method.getMethodName();
	       logger.info("Test Case Executed: " + testMethodName +"." +testClassName);
	       }
  }

  public void screenShot(WebDriver driver, String tname) throws IOException {
	  
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File SrcFile = ts.getScreenshotAs(OutputType.FILE);
	  File destFile = new File(System.getProperty("user.dir")+"/screenshot/"+tname+".png");
	  FileUtils.copyFile(SrcFile, destFile);
	  logger.info("screenshot taken for testcase: "+tname);
  }
  

}
