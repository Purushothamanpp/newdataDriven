
package com.comcast.crm.objectrepositoryUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.Loginpage;
import com.comcast.crm.objectrepositoryUtility.OrganiztionsPage;
import com.comcast.crm.objectrepositoryUtility.oraganizationInfoPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		Fileutility Flib = new Fileutility();
		Excelutility Elib = new Excelutility();
		JavaUtility jlib = new JavaUtility();
		WebdriverUtility weblib = new WebdriverUtility();

		String sh = Elib.getDataFromExcel("Sheet1", 1, 7) + jlib.getRandomNumber();

		WebDriver driver = new ChromeDriver();
		driver.get(Flib.getDataFromPropertiesFile("link"));
		weblib.waitForPageToLoad(driver);
		weblib.minimize(driver);
		Loginpage lp = new Loginpage(driver);
		lp.loginToapp("link", "admin", "admin");

		// Step1.navigate to organization module
		HomePage op = new HomePage(driver);
		op.getOrgLink().click();

		// step2.click on create organization
		OrganiztionsPage org = new OrganiztionsPage(driver);
		org.getCreateNeworgBtn().click();

		// Step3.Enter the all the details @create new organization
		CreatingNewOrganizationPage cmpo = new CreatingNewOrganizationPage(driver);
		cmpo.createOrg(sh);
		cmpo.createorg("Construction");
		cmpo.EnterPhoneNumber("8774744447");
		// verify the header msg
		oraganizationInfoPage org1 = new oraganizationInfoPage(driver);

		String actorgname = org1.getHeadername().getText();
		if (actorgname.contains(sh)) {
			System.out.println(sh + "name is Verified ===PASS");
		} else {
			System.out.println(sh + "name is not verified===FAIL");
		}

		// go back to organizations page
		HomePage op1 = new HomePage(driver);
		op1.getOrgLink().click();

		// search for organization
		org.getSearchtext().sendKeys(sh);
		// In dynamic webtable select & delete org
		weblib.select(org.getSearchDD(), "Organization Name");
		org.getSeachedit().click();

		driver.findElement(By.xpath("//a[text()=\"" + sh + "\"]/../../td[8]/a[text()=\"del\"]")).click();

		weblib.AlertHandel(driver);
		// Step5 LogOut

		op.logout();

	}
}
