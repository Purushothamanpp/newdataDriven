package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excelutility {
 
	public String getDataFromExcel(String sheetName,int rowNum,int celnum) throws Throwable  {
		
		FileInputStream fis=new FileInputStream("./testscriptdata/Vtiger.xlsx");
	
			
		Workbook wb=WorkbookFactory.create(fis);
        Sheet sh=wb.getSheet(sheetName); 
        
        String row=sh.getRow(rowNum).getCell(celnum).toString();
       
              return row;
		
	}
		
  public int getRowcount(String sheetName) throws Throwable		{
	  
	  FileInputStream fis=new FileInputStream("./testScriptdata/testscriptdata.xlsx");
		
		
		Workbook wb=WorkbookFactory.create(fis);
		int rowNum=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowNum; 
		
		}
 public void SetDataIntoExcel(String sheetName   ,int rowNum,int celnum ,String set) throws Throwable		{
	  
	  FileInputStream fis=new FileInputStream("./testScriptdata/testscriptdata.xlsx");

		Workbook wb=WorkbookFactory.create(fis);
	Cell cel = wb.getSheet(sheetName).getRow(rowNum).createCell(celnum);
         cel.setCellValue(set);
		
		FileOutputStream fos=new FileOutputStream("./testScriptdata/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
		
 }
 
	
	}
