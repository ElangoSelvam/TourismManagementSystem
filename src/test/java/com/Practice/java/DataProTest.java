package com.Practice.java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.IpathConstants;

public class DataProTest {
	@Test(dataProvider = "test")
	public void run(String Company,String Location,String State,String Price) {
		System.out.println(Company+" "+Location+" "+State+" "+Price);
	}
	
	@DataProvider
	public Object[][] test() throws IOException, Throwable {
	ExcelUtility eLib=new ExcelUtility();
	Object[][] object = eLib.getDataFromExcel("Sheet4");
	return object;

	}
	

//	@DataProvider
//	 public Object[][] getDataFromExcel() throws Throwable, IOException {
//	     FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
//	     Workbook wb =WorkbookFactory.create(fis);
//	     Sheet sh=  wb.getSheet("Sheet4");
//	     int lastRow=sh.getLastRowNum();
//	     int lastcell=sh.getRow(0).getLastCellNum();
//	     
//	     Object [][]obj=new Object[lastRow+1][lastcell];
//	     for(int i=0;i<=lastRow;i++) {
//		   for(int j = 0;j<lastcell;j++) {
//			   obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
//		   }
//	   }
//	   return obj;
//	}
}