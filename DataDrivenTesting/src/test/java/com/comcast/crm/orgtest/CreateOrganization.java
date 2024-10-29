package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream("./configAppData/Script.properties");
		FileInputStream fos = new FileInputStream(
				"./testscript/V-tiger TestScript.xlsx\\\\");
		Properties pobj = new Properties();
		pobj.load(file);
		String ob = pobj.getProperty("browser");

		WebDriver driver = new ChromeDriver();
//	   if(ob.equalsIgnoreCase("chrome")) {
//		   
//		   driver=new ChromeDriver();
//		   
//	   }
		driver.get(pobj.getProperty("link"));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(pobj.getProperty("username"));
		WebElement arg = driver.findElement(By.name("user_password"));
		arg.sendKeys(pobj.getProperty("password"));
		arg.submit();

		Random ra = new Random();
		int r = ra.nextInt(19);
		int rb = ra.nextInt(100);

		Workbook wb = WorkbookFactory.create(fos);
		Sheet sh = wb.getSheet("Sheet1");
		String obj2 = sh.getRow(3).getCell(4).toString();
		String obj = sh.getRow(r).getCell(7).toString();
		String obj1 = sh.getRow(r).getCell(6).toString();

		String Industry = sh.getRow(1).getCell(8).toString();
		String Type = sh.getRow(1).getCell(9).toString();

		driver.findElement(By.xpath("//a[text()='" + obj2 + "']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		//driver.findElement(By.name("accountname")).sendKeys("PURU"+rb);

		driver.findElement(By.name("accountname")).sendKeys(obj+""+rb);
		WebElement wbsele = driver.findElement(By.name("industry"));
		WebElement wbsele1 = driver.findElement(By.name("accounttype"));

		Select sel = new Select(wbsele);
		sel.selectByVisibleText(Industry);

		Select sel2 = new Select(wbsele1);
		sel2.selectByVisibleText(Type);

		driver.findElement(By.name("phone")).sendKeys(obj1);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(300);
		

		// verify the industries and type info
		
		  String actIndustry =driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText(); 
		  if
		  (actIndustry.equals(Industry)) { 
			  System.out.println(Industry +"is created pass");
		  }
		  
		   else { 
			  System.out.println(Industry + "is created fail");
		 

		}
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.contains(Type)) {
			System.out.println(Type + " is created pass");

		} else {
			System.out.println(Type + " is created fail");

		}
		driver.quit();

	}

}
