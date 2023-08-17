package com.Practice.java;

import org.testng.annotations.Test;

public class DataProviderDataTest {
	
	@Test(dataProviderClass = DataProvidingTest.class,dataProvider = "data1")
	public void tourism(String app,String name,String Package,int value) {
		System.out.println("app--->"+app+"  name--->"+name+"  Package--->"+Package+"   value--->"+value);
	}
	@Test(dataProviderClass = DataProvidingTest.class,dataProvider = "data2")
	public void foodOrder(String order,String names,String dish,int price) {
		System.out.println("order---->"+order+"   names---->"+names+"  dish---->"+dish+"  price---->"+price);
	}
	

}
