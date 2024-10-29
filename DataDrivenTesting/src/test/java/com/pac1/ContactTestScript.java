package com.pac1;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryUtility.ContactInfopage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganiztionsPage;
import com.comcast.crm.objectrepositoryUtility.VendoreUrlpage;
import com.comcast.crm.objectrepositoryUtility.Vendorspage;
import com.comcast.crm.objectrepositoryUtility.contactpage;
import com.comcast.crm.objectrepositoryUtility.oraganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.productspage;

import practice.pom.repository.ProductInfo;

public class ContactTestScript extends BaseClass{
	
	@Test  (groups="smokeTest")   
	
 public void contactTest2() throws Throwable{

			String sh = Elib.getDataFromExcel("Sheet1", 1, 7) + jlib.getRandomNumber();
			String sh1 = Elib.getDataFromExcel("Sheet1", 1,10) + jlib.getRandomNumber();
	
		   weblib.waitForPageToLoad(driver);
			  weblib.minimize(driver);

			HomePage cot=new HomePage(driver);
			cot.getContactlink().click();
			OrganiztionsPage org=new OrganiztionsPage(driver);
			contactpage cont=new contactpage(driver);
			cont.getContactlink().click();
		
			ContactInfopage Ent=new ContactInfopage(driver);
		     weblib.select(Ent.getClicklnone(),"Mr.");
			
			Ent.firstname(sh);
			Ent.lastname(sh1);
			Ent.getSave().click();
		String	actHeader=Ent.getVerify().getText();
		boolean status=actHeader.contains(sh);
	    Assert.assertEquals(status,true);
				}
          	
	
	@Test(groups="regressionTest")
	public void teContact() throws Throwable {
		String sh = Elib.getDataFromExcel("Sheet1", 1, 7) + jlib.getRandomNumber();
		   
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
		Thread.sleep(3000);
		proinfo.getVendoreimg().click(); 
		String parent = driver.getWindowHandle();
		String click = Elib.getDataFromExcel("Sheet1", 1, 12);
		weblib.SwitchToTabOnTitle(driver,click);
		VendoreUrlpage vendore = new VendoreUrlpage(driver);
		vendore.getClick().click();
		driver.switchTo().window(parent);
		weblib.scrolltoElement(driver,vendore.getFile());
	
		//vendore.getFile().sendKeys("D:\\portfolio\\image\\purushoth08");

	
	}
	
    @Test//(groups="regressionTest") 

	public void reateOrganization() throws Throwable {
		String sh = Elib.getDataFromExcel("Sheet1", 1, 7) + jlib.getRandomNumber();
		
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
		
	}
	
	
	
	
	
	
	
}
