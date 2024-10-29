package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendoreUrlpage {


	 WebDriver driver;
	    public VendoreUrlpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='javascript:window.close();'][1]")
     private  WebElement click;
	
	public WebElement getClick() {
		return click;
		
	}
	
	@FindBy(xpath="//input[@id='my_file_element']")
	private WebElement file;
	
	public WebElement getFile() {
		return file;
		
	}
	
	
	
}
