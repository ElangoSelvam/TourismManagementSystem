package com.TestNG;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.MyTourHistoryPage;
import com.tms.ObjectRepository.PackageDetailsPage;
import com.tms.ObjectRepository.TmsHomePage;
import com.tms.ObjectRepository.UserHomePage;

public class BookingTourCancelTest extends BaseClass {
	@Test(priority = 2,groups = "Smoke")
	public void bookCancel() {
		TmsHomePage tms=new TmsHomePage(driver);
		tms.homeBtn();
		wLib.scrollBarAction(driver);
		//Booking the tour package
		HomePage hp=new HomePage(driver);
		hp.detailsBtn();
		wLib.scrollBarAction(driver);
		PackageDetailsPage pdp=new PackageDetailsPage(driver);
		pdp.SelcetDate();
		wLib.scrollBarAction(driver);
		pdp.comment("Safety and Secure");
		pdp.bookbtn();	
		pdp.successBtn("SUCCESS");
		UserHomePage uhp=new UserHomePage(driver);
		uhp.tourHistory();
		//Cancel the Tour package 
		MyTourHistoryPage mth=new MyTourHistoryPage(driver);
		mth.tourHistoryPage();
		wLib.acceptAlert(driver);
		mth.successMsg("SUCCESS");
		
	}
	}
