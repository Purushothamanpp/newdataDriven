package Property;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipuleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		
		FileInputStream fis=new FileInputStream("./testScriptdata/testscriptdata.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
              org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Sheet1");
     
              

             
             for(int i=0;i<=10;i++) {
            	 Row row=sh.getRow(i);
                 
                 
                 int cellcount=row.getLastCellNum();
                  
                for(int j=0;j<cellcount;j++)
                  {
                	  
                 String columndata=row.getCell(j).toString();
                 //String column2data=row1.getCell(i).toString();
                 
                 System.out.print(columndata+" ");
                 
                  }
                System.out.println();
            	 
             }
 /* int rowshow=sh.getLastRowNum();
             
             for(int i=1;i<=rowshow;i++) {
            	 
                 Row row=sh.getRow(0);
                 Row row1=sh.getRow(1);
                 
                 String column1data=row.getCell(i).toString();
                 String column2data=row1.getCell(i).toString();
                 
                 System.out.println(column1data  +"\t"+column2data);
            	 
            	 
             }
        */     
             
  
         
             
              

	}

}

