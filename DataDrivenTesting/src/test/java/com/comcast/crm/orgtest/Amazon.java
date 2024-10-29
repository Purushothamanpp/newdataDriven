package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
	
		   WebDriver driver=new ChromeDriver();
		   driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puma");
	   
	 // WebElement web=driver.findElement(By.xpath("(//div[@class=\"s-suggestion-container\"])[4]"));
	   
	   Thread.sleep(2000);
	   Actions act=new Actions(driver);
       WebElement web1=driver.findElement(By.xpath("(//div[@class=\"s-suggestion s-suggestion-ellipsis-direction\"])[4]"));
       act.moveToElement(web1).click().perform();
    List<WebElement> web=driver.findElements(By.xpath("//span[@class='a-price-whole']"));   
    List<WebElement> web11=driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]")); 
    for(int i=0;i<web11.size();i++) {
    	
    	String s=web.get(i).getText().replaceAll(",", "");
    	int value=Integer.parseInt(s);
    	if(value<=2000) {
    		
    		System.out.println(web11.get(i).getText()+" : "+value);
    	}
    }
	
	  Thread.sleep(2000);
	  driver.quit();
	  
	  
	  

	}

}
