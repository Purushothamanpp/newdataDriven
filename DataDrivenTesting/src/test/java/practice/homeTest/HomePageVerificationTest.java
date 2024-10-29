package practice.homeTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryUtility.Loginpage;

public class HomePageVerificationTest {


	@Test
	public void homePageTest(Method mtd) throws Throwable {
		System.out.println(mtd.getName()+"Test Start");
		String exptectedPage="Home page";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	    String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')] ")).getText();
	   
	   if(actTitle.trim().equals(exptectedPage)) {
		   System.out.println(exptectedPage+"page is verified==PASS");
	   }
	   else {
		   System.out.println(exptectedPage+"page is verified==FAIL");
	   }
	   driver.close();
	   System.out.println(mtd.getName()+"Test End");
	   
		/*
		 * HomePage hom=new HomePage(driver); hom.logout();
		 */
	    
	}
	

	@Test
	public void VerifyLogoHomePageTest(Method mtd) throws Throwable {
		String exptectedPage="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status=driver.findElement(By.xpath("//img[@src=\"test/logo/vtiger-crm-logo.gif\"]")).isEnabled();
		  if(status) {
			   System.out.println(exptectedPage+"Logo is verified==PASS");
		   }
		   else {
			   System.out.println(exptectedPage+"Logo is not verified==FAIL");
		   }
		  driver.close();
		   System.out.println(mtd.getName()+"Test End");
		   //HomePage hom=new HomePage(driver);
		   
	
}}
