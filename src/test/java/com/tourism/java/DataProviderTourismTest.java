package com.tourism.java;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tms.GenericUtility.ExcelUtility;

public class DataProviderTourismTest {
	@Test(dataProvider = "tourismData")
	public void toursim(String locators,String values) {
		System.out.println(locators+" "+values);
	}
	
	
	@DataProvider
	public Object[][] tourismData() throws IOException, Throwable {
		ExcelUtility eLib=new ExcelUtility();
		Object[][] object = eLib.getDataFromExcel("Sheet1");
		return object;
		
	}

}
