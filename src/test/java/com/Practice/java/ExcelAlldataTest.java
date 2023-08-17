package com.Practice.java;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelAlldataTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		DataFormatter df=new DataFormatter();
		FileInputStream fis = new FileInputStream(".//src/test/resources/TestdataExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		for(int i=0;i<sh.getLastRowNum();i++) {
			for(int j=1;j<sh.getRow(i).getLastCellNum();j++) {
				//String data=df.formatCellValue(null)
						
						
				
			}
			
		}
		
		
		
		
	}

}
