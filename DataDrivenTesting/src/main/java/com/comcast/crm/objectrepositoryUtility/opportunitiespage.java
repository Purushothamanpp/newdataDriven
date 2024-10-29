package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class opportunitiespage {

	WebDriver driver;

	public opportunitiespage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()=\"Opportunities\"])[1]")
	private WebElement clickopp;

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement oppimgclick;

	@FindBy(name = "potentialname")
	private WebElement oppname;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement enteroppname;

	@FindBy(id = "related_to_display")
	private WebElement enteropp;

	@FindBy(xpath = "(//a[@href='javascript:window.close();'])[1]")
	private WebElement linkclick;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verify;

	public WebElement getVerify() {
		return verify;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getLinkclick() {
		return linkclick;
	}

	public WebElement getClickopp() {
		return clickopp;
	}

	public WebElement getOppimgclick() {
		return oppimgclick;
	}

	public WebElement getOppname() {
		return oppname;
	}

	public WebElement getEnteroppname() {
		return enteroppname;
	}

	public WebElement getEnteropp() {
		return enteropp;
	}

}
