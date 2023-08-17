package com.Practice.java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tms.GenericUtility.IpathConstants;

public class DataProviderTest {
	
	@DataProvider
	public Object[][] dataProvider() {
		Object [] [] obj=new  Object[2][3];
		obj[0][0]="Ooty";
		obj[0][1]="Tirupati";
		obj[0][2]=3000;
		
		obj[1][0]="Mysore";
		obj[1][1]="Hosur";
		obj[1][2]=1500;
		return obj;
		}
	@Test(dataProvider="dataProvider")
	
	public void dataTest(String From,String To,int Price) {
		
		System.out.println(From+" "+To+" "+ Price);
	}
	

}
