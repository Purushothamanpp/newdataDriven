package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganiztionsPage {
 
	WebDriver driver;
	public OrganiztionsPage(WebDriver driver) {
		this .driver=driver;
		PageFactory.initElements(driver,this);
    }
	
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	 private WebElement createNeworgBtn;
	
	@FindBy(name="search_text")
    private WebElement searchtext;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement seachedit;
	

	public WebElement getSearchDD() {
		return searchDD;
	}


	
	public WebElement getSearchtext() {
		return searchtext;
	}
	
    
	public WebElement getCreateNeworgBtn() {
		return createNeworgBtn;
	} 
	
	public WebElement getSeachedit() {
		return seachedit;
	}
}
