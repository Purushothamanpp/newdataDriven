package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonColor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		   WebDriver driver=new ChromeDriver();
		   driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	   
	 // WebElement web=driver.findElement(By.xpath("(//div[@class=\"s-suggestion-container\"])[4]"));
	   
	   Thread.sleep(2000);
	   Actions act=new Actions(driver);
       WebElement web1=driver.findElement(By.xpath("(//div[@class=\"s-suggestion s-suggestion-ellipsis-direction\"])[1]"));
       act.moveToElement(web1).click().perform();
	List<WebElement> act1=driver.findElements(By.xpath("//span[.='Apple iPhone 16 Plus (128 GB) - White'] /ancestor::div[@class='puisg-col-inner']//div[@class='a-"
			+ "section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
	for(WebElement Elem:act1) {
		
		System.out.println(Elem.getAttribute("aria-label"));
	}
	
		
		
		
		
		
	}

}
