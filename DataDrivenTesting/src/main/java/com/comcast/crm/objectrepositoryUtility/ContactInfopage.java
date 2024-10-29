package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfopage {

	WebDriver driver;

	public ContactInfopage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="salutationtype")
 private WebElement clicklnone;
	

	@FindBy(name="firstname")
	private WebElement FirstName;
	
	@FindBy(name="lastname")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement save;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verify;
	
	public WebElement getVerify() {
		return verify;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getClicklnone() {
		return clicklnone;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}
	
	
	public void firstname(String firstname) {
		FirstName.sendKeys(firstname);
	
		
	}
   public void lastname(String lastname) {
		LastName.sendKeys(lastname);
   }
	
}
