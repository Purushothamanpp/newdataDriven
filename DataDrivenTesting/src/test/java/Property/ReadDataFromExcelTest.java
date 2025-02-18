package Property;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		// first step1:get the excel path location & java object of the physical Excelfile
		
		FileInputStream fis=new FileInputStream("./testScript/V-tiger TestScript.xlsx\\\\\\\\");
				
		
		//step2 : open workbook in read mode
		
		 Workbook wb=WorkbookFactory.create(fis);
		 
		 // step3:get the control of the "org" sheet
        Sheet sh = wb.getSheet("org");
        
        
         //step4 get the control of the "1st" Row
        
       Row row=sh.getRow(1);
       
       // step5:get the control of the "2st" cell & read the string data 
       
       String data=  row.getCell(3).toString();
       System.out.println(data);
       
     
        
	}

}
