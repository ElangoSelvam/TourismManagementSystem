package com.TestNG;

import static org.testng.Assert.*;

import java.io.File;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;

import com.tms.ObjectRepository.AdminCreateTourPackagepage;
import com.tms.ObjectRepository.AdminDashboardPage;
@Listeners(com.tms.GenericUtility.ITestListnerImp.class)
public class AdmincreateTest  extends BaseClass{
@Test

	public void createTest() throws Throwable {
		
		

	AdminDashboardPage adp=new AdminDashboardPage(driver);
    adp.tourpack(driver);
    //fetching the data from the excel Sheet
    HashMap<String, String> getdata = eLib.getMultipleExcelData("Sheet1", 0, 1, "CREATE", driver);
    AdminCreateTourPackagepage actp=new AdminCreateTourPackagepage(driver);
    actp.createTour(driver, 10,getdata);
   // actp.createTour("Holiday","Family","Dubai","4000","Food and accomadation","Safety and secure");
    wLib.scrollBarAction(driver);
    File f=new File(".//src/test/resources/WhatsApp Image 2023-07-13 at 4.36.15 PM.jpeg");
    String abpath = f.getAbsolutePath();
    actp.packageImage(abpath);
    Thread.sleep(1000);
    wLib.scrollBarAction(driver);
    fail();
    actp.createPackage();
    Thread.sleep(1000);
    actp.successMsg("SUCCESS");
	}
}
