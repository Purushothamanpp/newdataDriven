package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Spicejet {

	public static void main(String[] args) throws Throwable {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notificatons");
		ChromeDriver driver=new ChromeDriver(opt);
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[.='round trip']")).click();
		driver.findElement(By.xpath("//input[@autocapitalize=\"sentences\" and @autocomplete=\"on\"]")).sendKeys("MAA");
		driver.findElement(By.xpath("(//input[@autocapitalize=\"sentences\" and @autocomplete=\"on\" and @class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys("KQH");
		driver.findElement(By.xpath("//div[.='24']")).click();
		//
		driver.findElement(By.xpath("//div[.='31']")).click();
		driver.findElement(By.xpath("//div[.='Passengers']")).click();
		
		//
		driver.findElement(By.xpath("//div[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
		driver.findElement(By.xpath("//div[@data-testid=\"Infant-testID-plus-one-cta\"]")).click();
		driver.findElement(By.xpath("//div[@data-testid=\"Infant-testID-plus-one-cta\"]")).click();
		driver.findElement(By.xpath("//div[.='Done']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
	
		
		
		
		

	}

}
