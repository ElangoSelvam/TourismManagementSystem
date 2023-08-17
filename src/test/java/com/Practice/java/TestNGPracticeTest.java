package com.Practice.java;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPracticeTest {
  @Test
  
  public void createTour() {
	 // int[] a= {1,2,3,4,5,6};
	System.out.println("Created Tour Successfully");
	  //System.out.println(a[7]);
    }
	@Test(dependsOnMethods = "createTour")
  public void manageTour() {
	  System.out.println("Manage Tour Successfully");
  }
	@Test(dependsOnMethods = "manageTour")
	public void processTour(){
		System.out.println("Tour Package processing");
	}
  @Test 
  @Ignore
  public void cancelTour() {
	  System.out.println("Canceled Tour Successfully");
  }
  
  
  
	
	
	
	
	
	
}
