package com.comcast.crm.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.VendoreUrlpage;
import com.comcast.crm.objectrepositoryUtility.Vendorspage;
import com.comcast.crm.objectrepositoryUtility.productspage;

import practice.pom.repository.ProductInfo;

public class Localhostproject{
	public static void main(String[] arg) throws Throwable {
		
		Excelutility Elib=new Excelutility ();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility weblib=new WebdriverUtility();
		WebDriver driver=new ChromeDriver();
		   //Elib.getDataFromExcel("Sheet1", 1, 7);
		String sh =Elib.getDataFromExcel("Sheet1", 1, 7)+ jlib.getRandomNumber();
   
		// Step1.navigate to organization module
		HomePage op = new HomePage(driver);
		op.getMoreLink().click();
		op.getVendors().click();

		Vendorspage vrn = new Vendorspage(driver);
		vrn.getSavebutton().click();
		vrn.vendorname1(sh);
		vrn.getSave().click();

		String verfiyVendore = vrn.getVerifylink().getText();

		if (verfiyVendore.contains(sh)) {
			System.out.println(verfiyVendore + "verify is passed");
		} else {
			System.out.println(verfiyVendore + "verify is faild");
		}

		op.getProduct().click();

		productspage prd = new productspage(driver);
		prd.getLinkimg().click();

		ProductInfo proinfo = new ProductInfo(driver);
		proinfo.producrname1(sh);
		proinfo.Calander(jlib.getSystemdateYYYDDMM());
		proinfo.enddate(jlib.getRequriedDateyyyDDMM());
		proinfo.getVendoreimg().click(); 
		String parent = driver.getWindowHandle();
		String click = Elib.getDataFromExcel("Sheet1", 1, 12);
		weblib.SwitchToTabOnTitle(driver,click);
		VendoreUrlpage vendore = new VendoreUrlpage(driver);
		vendore.getClick().click();
		driver.switchTo().window(parent);
		weblib.scrolltoElement(driver,vendore.getFile());
	
		vendore.getFile().sendKeys("D:\\portfolio\\image\\purushoth08");

	}
}
