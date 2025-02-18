package Property;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Linkfeatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	List<WebElement> list	=driver.findElements(By.xpath("//a"));
		
		for( WebElement src :list) {
			String rc =src.getAttribute("href");
			System.out.println(rc);
			System.out.println();
			// int a=100000;
			//for(int i=0;i<=a-1;i++) {
				
				
			  }
			
			
			
		}
		
		
		
	}

