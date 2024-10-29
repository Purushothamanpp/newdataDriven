package com.pac1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestScreenShot {

	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		//setp1 Create object to EventFiring Webdriver
	    EventFiringWebDriver fdriver=new EventFiringWebDriver(driver);
		
	    //setp1 use getScreenshotAs method to get the file type of screenShot 
		File srcfile=fdriver.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(srcfile, new File("./screeeShot/test1.png"));
	       
	    }
}






