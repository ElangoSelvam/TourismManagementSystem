package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.ObjectRepository.AdminDashboardPage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminManageTourpackagePage;
import com.tms.ObjectRepository.TmsHomePage;
import com.tms.ObjectRepository.UpdateTourPackagePage;

public class AdminManageTest extends BaseClass {
	@Test
	public void ManageTour() {
		TmsHomePage tmp=new TmsHomePage(driver);
		AdminLoginPage alp=new AdminLoginPage(driver);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		AdminManageTourpackagePage amtp=new AdminManageTourpackagePage(driver);
		UpdateTourPackagePage utp=new UpdateTourPackagePage(driver);
		adp.tourpackman(driver);
		amtp.details();
        utp.packageNameUt("America"); 
        wLib.scrollBarAction(driver);
        utp.submitBtn();
        utp.succesMsg("SUCCESS");
	}

}
