package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class organizationTestScript {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream("./configAppData/Script.properties");
		FileInputStream fos = new FileInputStream(
				"./testscriptdata/Vtiger.xlsx\\\\");
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
		WebElement arg2 = driver.findElement(By.name("user_password"));
		arg2.sendKeys(pobj.getProperty("password"));
		arg2.submit();

		Random ra = new Random();
		int r = ra.nextInt(19);
		// int rb = ra.nextInt(100);

		Workbook wb = WorkbookFactory.create(fos);
		Sheet sh = wb.getSheet("Sheet1");
		String obj2 = sh.getRow(4).getCell(4).toString();
		String FirstName = sh.getRow(r).getCell(7).toString();
		String obj1 = sh.getRow(r).getCell(6).toString();
		String LastName = sh.getRow(r).getCell(10).toString();

		String Mr = sh.getRow(1).getCell(11).toString();
		// String Type = sh.getRow(1).getCell(9).toString();

		driver.findElement(By.xpath("//a[text()='" + obj2 + "']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		Date dateobj = new Date();

		SimpleDateFormat sim = new SimpleDateFormat("yyy-MM-dd");
		String StartDate = sim.format(dateobj);
		

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String EndDate = sim.format(cal.getTime());
		

		WebElement wbsele = driver.findElement(By.name("salutationtype"));
		Select sel = new Select(wbsele);
		sel.selectByVisibleText(Mr);

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
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


