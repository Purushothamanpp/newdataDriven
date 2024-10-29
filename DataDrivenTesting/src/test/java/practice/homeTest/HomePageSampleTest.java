package practice.homeTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {

	@Test
	public void homePageTest(Method mtd) throws Throwable {
		Reporter.log(null);
		Reporter.log(mtd.getName() + "Test Start");
		//SoftAssert assertobj=new SoftAssert();
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		//assertobj.assertEquals("Home","Home-page");
		Reporter.log("step-3",true);
		//assertobj.assertEquals("Home-CRM","Home-CRM");
		Reporter.log("step-4",true);
		//assertobj.assertAll();
		Reporter.log(mtd.getName() + "Test End");

		/*
		 * HomePage hom=new HomePage(driver); hom.logout();
		 */

	}

	@Test
	public void VerifyLogoHomePageTest(Method mtd) throws Throwable {
		Reporter.log(mtd.getName() + "Test Start");
		SoftAssert assertobj=new SoftAssert();
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		//assertobj.assertTrue(true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		//Reporter.log(mtd.getName() + "Test End");
		assertobj.assertAll();
		// HomePage hom=new HomePage(driver);
	}

	
}
