package com.Practice.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream(".//src/test/resources/TestdataExcel.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	// String text = wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
	wb.getSheet("Sheet1").getRow(1).createCell(3).setCellValue("gettt");
	//System.out.println(text);
	FileOutputStream fos=new FileOutputStream(".//src/test/resources/TestdataExcel.xlsx");
    wb.write(fos);
	wb.close();
}

}