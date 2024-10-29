package Pratice.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
public 	ExtentReports report;
	@BeforeSuite 
	public void configAS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Reuslts");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// ad Env information & create test
	    report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		
	}
	@AfterSuite
	public void configAs() {
		report.flush();
	}
	
	@Test
	public void createContactTest() {

		// spark report conifg
		
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO,"login to app");

		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact ");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is create Pass");
		} else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		System.out.println("login to app"); 

	}
	
	@Test
	public void createContactWithORG() {

		// spark report conifg
		
		ExtentTest test = report.createTest("createContactWithORG");
		test.log(Status.INFO,"login to app");

		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact ");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is create Pass");
		} else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		System.out.println("login to app"); 

	}
	@Test
	public void createContactWithPhoneNumber() {

		// spark report conifg
		
		ExtentTest test = report.createTest("createContactWithPhoneNumber");
		test.log(Status.INFO,"login to app");

		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact ");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is create Pass");
		} else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		System.out.println("login to app"); 

	}
	
	
	

}
