package com.tms.GenericUtility;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ExcelUtility {
public String getExceldata(String sheetName,int row,int cell) throws EncryptedDocumentException, Throwable  
{
	FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	return data;
}
public void setExcelData(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException 
{
	
	FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).createRow(row).createCell(cell).setCellValue(value);
	FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
	wb.write(fos);
	wb.close();
}
public int getLastRowNumber(String sheetName) throws Throwable 
{
	FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int count = sh.getLastRowNum();
	return count;
	
} 
public HashMap<String, String>  getMultipleExcelData(String sheetName,int keyCelNo,int valueCelNo,String expdata,WebDriver driver) throws Throwable {

	FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int count=sh.getLastRowNum();
	
	HashMap<String,String> hs=new HashMap<String,String>();
	JavaUtility jLib= new JavaUtility();
	for(int i=0;i<count;i++) {
	String key = sh.getRow(i).getCell(keyCelNo).getStringCellValue();
	String value = sh.getRow(i).getCell(valueCelNo).getStringCellValue();
	hs.put(key,value);
	}
	
	
	return hs;
}


    public Object[][] getDataFromExcel(String SheetName) throws Throwable, IOException {
     FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
     Workbook wb =WorkbookFactory.create(fis);
     Sheet sh=  wb.getSheet(SheetName);
     int lastRow=sh.getLastRowNum();
     int lastcell=sh.getRow(0).getLastCellNum();
     Object [][]obj=new Object[lastRow+1][lastcell];
     for(int i=0;i<=lastRow;i++) {
	   for(int j = 0;j<lastcell;j++) {
		   obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	   }
   }
   return obj;
}




	
}
