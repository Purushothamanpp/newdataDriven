package practice.homeTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadData {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		/*
		 * FileInputStream fis=new FileInputStream("./testscriptdata/Vtiger.xlsx");
		 * Workbook wb=WorkbookFactory.create(fis); // Sheet sh=wb.getSheet("Sheet1");
		 * int count=sh.getLastRowNum(); // for(int i=1;i<count;i++) { // Row
		 * row=sh.getRow(i); // String first=row.getCell(1).getStringCellValue(); //
		 * String first1=row.getCell(2).getStringCellValue(); // //
		 * System.out.println(first +""+first1);
		 * 
		 * 
		 * FileInputStream fis=new FileInputStream("./testscriptdata/Vtiger.xlsx");
		 * Workbook wb=WorkbookFactory.create(fis); Sheet sh=wb.getSheet("Sheet1"); Row
		 * row=sh.getRow(4);
		 * 
		 * Cell cel=row.getCell(5); String data=cel.getStringCellValue();
		 * System.out.println(data);
		 * 
		 * 
		 * Cell cell=row.createCell(5); cell.setCellValue("purushoth"); FileOutputStream
		 * fis1=new FileOutputStream("./testscriptdata/Vtiger.xlsx"); wb.write(fis1);
		 */
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			/*
			 * driver.get("https://www.amazon.in/");
			 * driver.navigate().to("https://www.amazon.in/deals?ref_=nav_cs");
			 */
		 driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
		 driver.manage().window().maximize();
		 

		 
		 //driver.navigate().refresh();
					/*
			 * Robot rt=new Robot(); rt.keyPress(KeyEvent.VK_CONTROL);
			 * rt.keyPress(KeyEvent.VK_F5); rt.keyRelease(KeyEvent.VK_CONTROL);
			 * rt.keyRelease(KeyEvent.VK_F5);
			 */
		
	}

}
