package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendorspage {

	WebDriver driver;
	public Vendorspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement savebutton;
	
	@FindBy(name="vendorname")
	private WebElement vendorname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
    private WebElement verifylink;
	
	
	public WebElement getVerifylink() {
		return verifylink;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getVendorname() {
		return vendorname;	
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	    public void  vendorname1(String name) {
	    	vendorname.sendKeys(name);
	    	
	    }
	
}
