package com.TestNG;

import org.testng.annotations.Test;


import com.tms.GenericUtility.BaseClass;

public class AdminTest  {
	@Test(groups = "Smoke")
	public void createTour() {
		System.out.println("Tour Created");
	}
	@Test(groups = "ReginalRegression")
	public void manageTour() {
		System.out.println("Tour Managed");
	}
	
	

}
