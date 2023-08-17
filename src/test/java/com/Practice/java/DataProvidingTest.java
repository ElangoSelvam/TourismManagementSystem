package com.Practice.java;

import org.testng.annotations.DataProvider;

public class DataProvidingTest {
	@DataProvider
	public Object[][] data1() {
		Object[][] obj=new Object[2][4];
		
		obj[0][0]="Tourism Management";
		obj[0][1]="Admin";
		obj[0][2]="Tour Package";
		obj[0][3]=1;
		
		obj[1][0]="Tourism";
		obj[1][1]="User";
		obj[1][2]="Manage Package";
		obj[1][3]=2;
		
		return obj;
		
	}
	@DataProvider
	public Object[][] data2() {
        Object[][] obj=new Object[2][4];
		
		obj[0][0]="Food Ordering App";
		obj[0][1]="Customer name";
		obj[0][2]="Dishes";
		obj[0][3]=100;
		
		obj[1][0]="Online";
		obj[1][1]="Akash";
		obj[1][2]="Chicken biriyani";
		obj[1][3]=1;
		
		return obj;
		
		
	}
	
	

}
