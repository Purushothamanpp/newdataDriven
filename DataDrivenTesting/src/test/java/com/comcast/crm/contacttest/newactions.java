package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class newactions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		Actions act = new Actions(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*
		 * WebElement a
		 * =driver.findElement(By.xpath("(//img[@alt=\"User Avatar\"])[1]"));
		 * act.moveToElement(a).perform(); String b =
		 * driver.findElement(By.xpath("(//div[@class=\"figcaption\"])[1]")).getText();
		 * System.out.println(b);
		 */
		
		
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your username\"]")).sendKeys("purushothaman");
	}

}
