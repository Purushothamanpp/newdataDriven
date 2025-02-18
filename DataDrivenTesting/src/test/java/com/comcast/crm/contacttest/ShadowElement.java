package com.comcast.crm.contacttest;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		WebElement rec = driver.findElement(By.xpath("//div[@class=\"my-3\"][1]"));
		SearchContext sh = rec.getShadowRoot();
		sh.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).sendKeys("purushoth");
		WebElement pass = driver.findElement(By.xpath("//div[@class=\"my-3\"][2]"));
		SearchContext sh1 = pass.getShadowRoot();
		sh1.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).sendKeys("purus");

		Actions act = new Actions(driver);
	    act.sendKeys(args);
		

	}

}
