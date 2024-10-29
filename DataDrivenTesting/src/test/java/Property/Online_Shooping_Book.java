package Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Online_Shooping_Book {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fil = new FileInputStream("./configAppData/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fil);

		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		System.out.println(USERNAME);
		String Password = pobj.getProperty("password");


		//String Click=pobj.getProperty("click");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();

		driver.findElement(By.xpath("//input[@name=\"login_username\"]")).sendKeys(USERNAME);
		driver.findElement(By.name("login_password")).sendKeys(Password);
		driver.findElement(By.xpath("(//button[@name=\"submit\"])[1]")).click();
		Alert org = driver.switchTo().alert();
		org.accept();
		driver.findElement(By.xpath("//a[text()=\" Literature & Fiction \"]")).click();
	
		
		FileInputStream file=new FileInputStream("C:\\Users\\purushothaman\\OneDrive\\Desktop\\New folder (3)\\smokingtesting1.xlsx");
		
//	          Workbook fb=WorkbookFactory.create(file);
//	          Sheet sh = fb.getSheet("Org");
//	          Row sh1=sh.getRow(2);
//	          String cel=sh1.getCell(0).toString();
//	          System.out.println(cel);
//	          
		         WebElement selec=driver.findElement(By.xpath("//select[@name=\"sort\"]"));
		         selec.click();
		         
		         Select slc=new Select(selec);
		        slc.selectByIndex(1);
		        driver.findElement(By.xpath("(//img[@class=\"book block-center img-responsive\"])[2]")).click();
		        WebElement  select1=driver.findElement(By.id("quantity"));
		        Select select=new Select(select1);
		        
		         select.selectByIndex(1);
		         driver.findElement(By.id("buyLink")).click();
		         //driver.findElement(By.xpath("//a[@class='btn btn-sm']")).click();
		         
		           Actions src=new Actions(driver);
		           WebElement ab=driver.findElement(By.xpath("//img[@style='margin:auto']"));
		           src.scrollToElement(ab);
		           
		           
		           //WebElement scrol1=driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"));
		           WebElement scrol2=driver.findElement(By.xpath("//a[@href='cart.php?place=true']"));
		           scrol2.click();
		      
		           	
		  
		
		         
		           
		  
		         
		         
		         
		         
		         
		         
		         
		         
		         //Actions action=new Actions(driver);
		         
	         //
	         
	         
	          //slc.
	          
	        		  

	}

}
