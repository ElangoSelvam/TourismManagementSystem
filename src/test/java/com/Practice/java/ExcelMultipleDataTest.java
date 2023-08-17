package com.Practice.java;

import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelMultipleDataTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream(".//src/test/resources/TestdataExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 int data = wb.getSheet("Sheet1").getLastRowNum();
		for(int i=0;i<=data;i++) {
		String src=wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
		String des=wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
		System.out.println(src+" "+des);
		}

	}
}
