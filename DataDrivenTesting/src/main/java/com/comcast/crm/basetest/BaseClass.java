package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.Loginpage;


public class BaseClass {

	public 	 DataBaseutility dblib = new DataBaseutility();
	public  Fileutility flib = new Fileutility();
	public  WebDriver driver = null;
	public static  WebDriver sdriver;
	public  Excelutility Elib = new Excelutility();
	public  JavaUtility jlib = new JavaUtility();
	public  WebdriverUtility weblib = new WebdriverUtility();
	ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws Throwable {
		System.out.println("Connect to DB , Report Config");
		dblib.getDbconnection();
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

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Throwable {
		System.out.println("===Launch the BROWSER==");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver = new ChromeDriver();
		sdriver = driver;
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {
		System.out.println("===Login==");
		String URL = flib.getDataFromPropertiesFile("link");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		Loginpage lp = new Loginpage(driver);
		lp.loginToapp(URL, Username, Password);

	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAfterMethod() {
		System.out.println("===Logout===+");

		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() throws Throwable {
		System.out.println("=== Close the BROWSER===");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() throws Throwable {
		System.out.println("=====close Db , Report backUP=====");
		dblib.closeDbconnection();
		report.flush();
	}

}
