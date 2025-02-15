package com.softbank.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.softbank.testcases.BaseClass;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter ehr;
	public ExtentReports er;
	public ExtentTest et;
	WebDriver driver=null;
	
	@Override
	public void onStart(ITestContext testcontext) {
		
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname = "Test-Report"+date+".html";
		String reportpath = System.getProperty("user.dir")+"/test-output/"+reportname;
		System.out.println(reportpath);
		
		ehr = new ExtentHtmlReporter(reportpath);
		ehr.loadXMLConfig(System.getProperty("user.dir")+"/configuration/"+"extent-config.xml");
		
		er = new ExtentReports();
		er.attachReporter(ehr);
		er.setSystemInfo("Host name", "localhost");
		er.setSystemInfo("Environment", "QA");
		er.setSystemInfo("user", "vipin");

		 ehr.config().setDocumentTitle("mobile testing");
		 ehr.config().setReportName("functional test report");
		 ehr.config().setTestViewChartLocation(ChartLocation.TOP);
		 ehr.config().setTheme(Theme.DARK);

	}
	
	@Override
	public void onTestSuccess(ITestResult itr) {
		System.out.println("created report and adding details");
		et = er.createTest(itr.getName());
		et.log(Status.PASS, MarkupHelper.createLabel(itr.getName(), ExtentColor.GREEN));
	}
	
	@Override
	public void onTestFailure(ITestResult itr) {
		
		et = er.createTest(itr.getName());
		et.log(Status.FAIL, MarkupHelper.createLabel(itr.getName(),ExtentColor.RED));
		
		BaseClass bs = new BaseClass();
		driver = BaseClass.driver;
		try {
			bs.screenShot(driver, itr.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 @Override
	 public void onFinish(ITestContext tr) {
		 er.flush();
	 }
}
