	package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	
	public void minimize(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	public void WaitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void SwitchToTabOnURL(WebDriver driver,String partailUrl) {
		Set<String>set=driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		while(it.hasNext()){
		String WindowId=it.next();
		driver.switchTo().window(WindowId);
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains(partailUrl)) {
			break;
		}
		
		}
		}
	
	public void SwitchToTabOnTitle(WebDriver driver,String wind) {
		Set<String> window=driver.getWindowHandles();
		for(String childwindow:window) {
			driver.switchTo().window(childwindow);
			String currenturl=driver.getTitle();
			if(currenturl.contains(wind)){
				break;
			}
		}
	
		
		}
	
	public void SwitchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		}
	public void SwitchtoFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
		
	}
	public void SwitchtoFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
		
	}
	
	public void SwitchtoAlertAndAccept(WebDriver driver) {
		
		driver.switchTo().alert().accept();
		
	}
	
public void SwitchtoAlertAndCancel(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
		}

public void select(WebElement element,String text) {
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}

public void select(WebElement element,int text) {
	Select sel=new Select(element);
	sel.selectByIndex(text);
	
}
public void mousemoveOnElement(WebDriver driver,WebElement element) {
	
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();;
	
}
public void doubleClickWebElement(WebDriver driver,WebElement element) {
	
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
	
}

public void dragANDdrop (WebDriver driver,WebElement element,WebElement element1) {
	
	Actions act=new Actions(driver);
	act.dragAndDrop(element, element1).perform();
	
}

public void scrolltoElement(WebDriver driver ,WebElement element) {
	
	Actions act=new Actions(driver);
	act.scrollToElement(element).perform();
}
  public void dropdown(WebElement element) {
	  
	  Select option=new Select(element);
	    List<WebElement>options=option.getOptions();
	           for(WebElement opion:options)
	           {
	        	   System.out.println(opion.getText());
	           }
  }

  public void TakescreenShot(WebDriver driver ,String foldername) {
	  TakesScreenshot screen=(TakesScreenshot)driver;
	            File  file1=screen.getScreenshotAs(OutputType.FILE);
			File desfile=new File("./Screenshot/foldername");
  }
 
  public void AlertHandel(WebDriver driver)
  {
	 Alert alt=driver.switchTo().alert();
	   alt.accept();
	   
  }
	
}
