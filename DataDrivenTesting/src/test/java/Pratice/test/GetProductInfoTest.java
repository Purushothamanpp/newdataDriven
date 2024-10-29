package Pratice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryUtility.amzonpage;

public class GetProductInfoTest {

	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName ,String productName) throws Throwable {
		WebdriverUtility webLib=new WebdriverUtility();
		Fileutility   filib=new Fileutility();
		WebdriverUtility web=new WebdriverUtility();
	    WebDriver driver=new ChromeDriver();
		driver.get(filib.getDataFromPropertiesFile("url"));
		web.minimize(driver);
		
		
		//Search product 
		
		amzonpage amz=new amzonpage(driver);
		amz.getSearch().sendKeys(brandName,Keys.ENTER);
	   String price=driver.findElement(By.xpath("//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[2]/div/a /span/span[2]/span[2]")).getText();
		System.out.println(price);
	   // capture product info
	    driver.quit();
		}

	@DataProvider
	public Object[][] getData() throws Throwable {
		Excelutility  Exleb=new Excelutility();
	int	rowCount=Exleb.getRowcount("product");
		
		Object[][] objArr = new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
		objArr[i][0] =Exleb.getDataFromExcel("product",i+1,0);
		objArr[i][1] = Exleb.getDataFromExcel("product",i+1,1);
		}

		return objArr; 
	}
	
	
	
}
