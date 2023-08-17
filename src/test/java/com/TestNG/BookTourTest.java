package com.TestNG;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.PackageDetailsPage;
import com.tms.ObjectRepository.TmsHomePage;

public class BookTourTest extends BaseClass {
	@Test(groups = "Regression")
public void bookTour() {
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
}
}
