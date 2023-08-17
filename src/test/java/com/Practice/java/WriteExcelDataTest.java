package com.Practice.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelDataTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream(".//src/test/resources/TestdataExcel.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	Row row = sheet.getRow(1);
	Cell cell = row.getCell(1);
	cell.setCellValue("Tourism");

	FileOutputStream fos=new FileOutputStream("./src/main/resources/Testdata.xlsx");
	wb.write(fos);
	wb.close();
}
	
	
	
	
}
