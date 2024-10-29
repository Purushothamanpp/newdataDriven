package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "accountname")
	private WebElement Entername;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutn;
	
	@FindBy(name="industry")
	private WebElement industryDW;
    
	
	@FindBy(id="phone")
    private WebElement phone;
	
   public WebElement getPhone() {
		return phone;
	}

	//////////////////////////////////////////////////////////////////
	public WebElement getEntername() {
		return Entername;
	}

	public WebElement getSave() {
		return savebutn;
	}

	public void createOrg(String orgName) {
	  Entername.sendKeys(orgName);
	  savebutn.click();
  }

      public void createorg(String inpustryp)

      { 
    	 Select stc=new Select(industryDW);
    	 stc.selectByVisibleText(inpustryp);
      }
   
   public void  EnterPhoneNumber(String phonenum) {
	   phone.sendKeys(phonenum);
	   
   }
   
   
}
