package Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Online_shopping_project2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		

		FileInputStream fil = new FileInputStream(
				"configAppData/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fil);

		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		System.out.println(USERNAME);
		String Password = pobj.getProperty("password");


		//String Click=pobj.getProperty("click");

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();

		driver.findElement(By.xpath("//input[@name=\"login_username\"]")).sendKeys(USERNAME);
		driver.findElement(By.name("login_password")).sendKeys(Password);
		driver.findElement(By.xpath("(//button[@name=\"submit\"])[1]")).click();
		Thread.sleep(2000);
		Alert org = driver.switchTo().alert();
		org.accept();
		driver.findElement(By.xpath("//a[contains(text(),' Children & Teens ')]")).click();
		  WebElement selec=driver.findElement(By.xpath("//select[@name=\"sort\"]"));
	         selec.click();
		
		 Select slc=new Select(selec);
	        slc.selectByIndex(3);
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//img[@class=\"book block-center img-responsive\"])[2]")).click();
	        WebElement  select1=driver.findElement(By.id("quantity"));
	        Select select=new Select(select1);
	        Thread.sleep(2000);
	         select.selectByIndex(2);
	         Thread.sleep(2000);
	         driver.findElement(By.id("buyLink")).click();
	         driver.findElement(By.xpath("//a[contains(text(),' LogOut')]")).click();
	         Thread.sleep(2000);
	         Alert art=driver.switchTo().alert();
	          art.accept();
	          driver.quit();
		
		
		

	}

}
