         package Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest12 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				"./configAppData/commondata.properties");

		Properties pobj = new Properties();
		pobj.load(fis);
		//String BROSWER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		

		Scanner s = new Scanner(System.in);
		System.out.println("enter the browser");
		String broswer = s.next();
		WebDriver driver = null;
		if (broswer.equals("chrome")) {

			driver = new ChromeDriver();}
		else if (broswer.equals("edge")) {
			driver = new EdgeDriver();
		} else if (broswer.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
// driver=new ChromeDriver();
		
		
		
		//login to app 
		driver.get(URL);
		driver.manage().window().maximize();
		

	

	//	driver.findElement(By.xpath("//a[text()=\"register\"]")).click();

	}

}
