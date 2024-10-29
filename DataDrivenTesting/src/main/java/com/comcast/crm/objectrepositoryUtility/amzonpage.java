package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amzonpage {

	
	WebDriver driver;
	
	public amzonpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	

	@FindBy(xpath="//span[text()='Apple iPhone 13 (128GB) - Midnight']/../../../../div[3]/div[1]/div/div[1]/div[2]/div/a /span/span[2]/span[2]")
	private WebElement findelement;
	

	public WebElement getFindelement() {
		return findelement;
	}

	public void geturl(String productname) {
		
		findelement.sendKeys(productname);
	}

	public WebElement getSearch() {
		return search;
	}
	
	
}
