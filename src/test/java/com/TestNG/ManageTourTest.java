package com.TestNG;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.ObjectRepository.AdmManageBookingPage;
import com.tms.ObjectRepository.AdminDashboardPage;


public class ManageTourTest extends BaseClass{
	@Test(priority=1,groups = "Smoke")
	
	
public void manageBook() {

	AdminDashboardPage adp=new AdminDashboardPage(driver);
	adp.managebookBtn();
	AdmManageBookingPage ambp=new AdmManageBookingPage(driver);
	ambp.managebook("Manage Bookings");
}
}
