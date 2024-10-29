package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream file = new FileInputStream("./configAppData/Script.properties");
		FileInputStream fos = new FileInputStream("./testscriptdata/Vtiger.xlsx");
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
		//String obj2 = sh.getRow(3).getCell(4).toString();
		String obj = sh.getRow(r).getCell(7).toString()+rb;
		String obj1 = sh.getRow(r).getCell(6).toString();

		String Industry = sh.getRow(1).getCell(8).toString();
		String Type = sh.getRow(1).getCell(9).toString();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		// driver.findElement(By.name("accountname")).sendKeys("PURU"+rb);

		driver.findElement(By.name("accountname")).sendKeys(obj + "" + rb);
		WebElement wbsele = driver.findElement(By.name("industry"));
		WebElement wbsele1 = driver.findElement(By.name("accounttype"));

		Select sel = new Select(wbsele);
		sel.selectByVisibleText(Industry);

		Select sel2 = new Select(wbsele1);
		sel2.selectByVisibleText(Type);

		driver.findElement(By.name("phone")).sendKeys(obj1);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(300);

		// verify the header phone massage
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (header.contains(obj)) {
			System.out.println(obj + "is created pass");
		} else {
			System.out.println(obj + "is created fail");
		}

		// navigate the conntect page

		String obj12 = sh.getRow(4).getCell(4).toString();
		String FirstName = sh.getRow(r).getCell(7).toString();
		String obj13 = sh.getRow(r).getCell(6).toString();
		String LastName = sh.getRow(r).getCell(10).toString();

		String Mr = sh.getRow(1).getCell(11).toString();
		// String Type = sh.getRow(1).getCell(9).toString();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		Date dateobj = new Date();

		SimpleDateFormat sim = new SimpleDateFormat("yyy-MM-dd");
		String StartDate = sim.format(dateobj);

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String EndDate = sim.format(cal.getTime());

		WebElement wbseles = driver.findElement(By.name("salutationtype"));
		Select sel1 = new Select(wbseles);
		sel1.selectByVisibleText(Mr);

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//Switch To child window
		
		 Set<String> set1=driver.getWindowHandles();
		 Iterator<String>it2=set1.iterator();
		 while(it2.hasNext()) {
			 
			String WindowID=it2.next();
			 driver.switchTo().window(WindowID);
			 String acturl=driver.getCurrentUrl();
			 if(acturl.contains("module=Accounts")) {
				 
                  break;
			 }
			 }

			driver.findElement(By.name("search_text")).sendKeys(obj);
			driver.findElement(By.name("search")).click();
			WebElement a = driver.findElement(By.xpath("//a[.='"+obj+"']"));
			Thread.sleep(1000);
			a.click();
		 
			 Set<String> set2=driver.getWindowHandles();
			 Iterator<String>it3=set2.iterator();
			 while(it3.hasNext()) {
				 
				String WindowID=it3.next();
				 driver.switchTo().window(WindowID);
				 String acturl=driver.getCurrentUrl();
				 if(acturl.contains("Contacts&action")) {
					 
	                  break;
				 }
				 }

		 
		 
		 
		 driver.findElement(By.name("phone")).sendKeys(obj1);

		// Date creation

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(StartDate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(EndDate);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(300);

		
		
	}

}
