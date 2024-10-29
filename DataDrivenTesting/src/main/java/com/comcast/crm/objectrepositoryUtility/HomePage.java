package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Rule-2 object Creation
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;

	@FindBy(linkText = "Contacts")
	private WebElement Contactlink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;

	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name="Vendors")
	private WebElement vendors;
	
    @FindBy(linkText="Products")
    private WebElement product ;
    
    @FindBy(name="Campaigns")
    private WebElement camp;
    

	public WebElement getProduct() {
		return product;
	}

	public WebElement getVendors() {
		return vendors;	
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement Signout;
	

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContactlink() {
		return Contactlink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getSignout() {
		return Signout;
	}

	public void setOrgLink(WebElement orgLink) {
		OrgLink = orgLink;
	}

	public void setContactlink(WebElement contactlink) {
		Contactlink = contactlink;
	}
	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public void navigateTocampaginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignlink.click();

	}

	public void  logout() {
	Actions act=new Actions(driver);
	act.moveToElement(adminImg).perform();
	Signout.click();
	}
	
}
