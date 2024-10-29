package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfo {

	

	WebDriver driver;
	public ProductInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

     @FindBy(name="productname")
    private WebElement producrname;
     
     @FindBy(name="sales_start_date")
     private WebElement calander;
    @FindBy(name="sales_end_date")
    private WebElement Enddate;
    
    @FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
     private WebElement vendoreimg;
    
    @FindBy(xpath="(//tr[@class='lvtColData'])[1]")
     private  WebElement HP;
    
    
	public WebElement getHP() {
		return HP;
	}
	public WebElement getVendoreimg() {
		return vendoreimg;
	}
	public WebElement getCalander() {
		return calander;
	}
	public WebElement getProducrname() {
		return producrname;
		
	}
	
  public void producrname1(String name)
  {
	  producrname.sendKeys(name);
  }
  public void Calander(String name) {
	  calander.sendKeys(name);
  }
	
  public void enddate(String name)
  {
	  Enddate.sendKeys(name);
  }

  
}
