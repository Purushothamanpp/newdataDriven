package com.comcast.crm.objectrepositoryUtility;

import javax.annotation.meta.TypeQualifier;

/**
 * 
 * @author purushothaman  
 * 
 * 
 * 
 * contains login page element & business lib link login()
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class Loginpage{
          //Rule-1 create a separte java class
	      //Rule-2 object Creation 
	WebDriver driver;
	public  Loginpage(WebDriver driver)
	{           this.driver=driver;
		PageFactory.initElements (driver,this);
	}
	
	
	@FindBy(name="user_name")
	WebElement usernameEdit;
	
	@FindBy(name="user_password")
	WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	WebElement submitEdit;
	
	
	//

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getSubmitEdit() {
		return submitEdit;
	}
	
	WebdriverUtility weblib=new WebdriverUtility();
	//Rule3:object 

	 /**
	  * 
	  * login to application based username,password,url arguments
	  * @param url
	  * @param username
	  */
  public void loginToapp(String url,String username,String password) {
	  weblib.waitForPageToLoad(driver);
	   driver.get(url);
	  driver.manage().window().maximize();
	  usernameEdit.sendKeys(username);
      passwordEdit.sendKeys(password);
      submitEdit.click();
  }
	
	
	
	
	
}
	
	
	
	
	
	