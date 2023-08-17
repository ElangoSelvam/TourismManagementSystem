package com.TestNG;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;

public class UserTest {
	@Test(groups = "Regression")
	public void bookTour() {
		System.out.println("Tour Booked ");
	}
	@Test(groups = "Smoke")
	public void cancelTour() {
		System.out.println("Tour cancelled");
	}
	@Test(groups="Regression")
	public void deleteTour() {
		System.out.println("Tour Deleted");
	}
	
}
