package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.Loginpage;
import com.comcast.crm.objectrepositoryUtility.campginespage;
import com.comcast.crm.objectrepositoryUtility.opportunitiespage;
import com.comcast.crm.objectrepositoryUtility.oraganizationInfoPage;

public class Campgines {

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
		lp.loginToapp("link","admin","admin");

		// Step1.navigate to organization module
		HomePage op = new HomePage(driver);
		op.getMoreLink().click();
		op.getCampaignlink().click();
		campginespage camp = new campginespage(driver);
		camp.getImgclick().click();
		camp.getCampname().sendKeys(sh);
		camp.getClickproduct().click();
		String parent = driver.getWindowHandle();
		String printer = Elib.getDataFromExcel("Sheet1", 1, 14);
		weblib.SwitchToTabOnTitle(driver, printer);
		camp.getLinkclick1().click();
		driver.switchTo().window(parent);
		camp.getSaveclick().click();
		String verify = camp.getVerify().getText();
		if (verify.contains(sh)) {
			System.out.println(verify + "verify is passed");
		} else {
			System.out.println(verify + "verify is fail");
		}
		opportunitiespage opp = new opportunitiespage(driver);

		opp.getClickopp().click();
		opp.getOppimgclick().click();
		opp.getOppname().sendKeys(sh);
		opp.getEnteroppname().click();
		String parent1 = driver.getWindowHandle();
		String click = Elib.getDataFromExcel("Sheet1", 2, 11);
		weblib.SwitchToTabOnTitle(driver, click);
		opp.getLinkclick().click();
		driver.switchTo().window(parent1);
		opp.getSavebutton().click();
	String	verifname=opp.getVerify().getText();
	
	if(verifname.contains(sh)) {
		System.out.println(verifname + "verify is passed");
	}
	else {
		System.out.println(verifname + "verify is fail");
	}
	
	op.logout();
	driver.quit();
	

	}
	
	

}