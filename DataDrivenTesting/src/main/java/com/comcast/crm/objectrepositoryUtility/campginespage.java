package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campginespage {

	WebDriver driver;

	public campginespage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement imgclick;

	@FindBy(name = "campaignname")
	private WebElement campname;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement clickproduct;

	@FindBy(xpath = "(//a[@href='javascript:window.close();'])[1]")
	private WebElement clcikproduct1;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveclick;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement verify;
	

	@FindBy(xpath="//a[text()=\"Printer\"]")
	private WebElement linkclick1;
	

	public WebElement getLinkclick1() {
		return linkclick1;
	}


	public WebElement getVerify() {
		return verify;
	}

	public WebElement getSaveclick() {
		return saveclick;
	}

	public WebElement getClickproduct() {
		return clickproduct;
	}

	public WebElement getClcikproduct1() {
		return clcikproduct1;
	}

	public WebElement getCampname() {
		return campname;
	}

	public WebElement getImgclick() {
		return imgclick;
	}

	@FindBy(linkText = "Contacts")
	private WebElement Contactlink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;

}
