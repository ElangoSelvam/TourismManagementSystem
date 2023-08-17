package com.tourism.java;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.FileUtililty;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.ObjectRepository.AdminCreateTourPackagepage;
import com.tms.ObjectRepository.AdminDashboardPage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.TmsHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TourCreateTest {

	public static void main(String[] args) throws Throwable {
	// Object Creation for Utility class
	ExcelUtility eLib=new ExcelUtility();
    WebDriverUtility wLib=new WebDriverUtility();
	FileUtililty fLib=new FileUtililty();
  
    // Fetching the data from the File Utility Class
    String Browser= fLib.getPropertyData("browser");
    String Url= fLib.getPropertyData("url");
    String Username= fLib.getPropertyData("username");
    String Password= fLib.getPropertyData("password");
	//Launching the browser
    WebDriver driver;
	if(Browser.equalsIgnoreCase("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
	}
	else if(Browser.equalsIgnoreCase("Chrome")) {
	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	driver.get(Url);
	wLib.windowMaximize(driver);
	wLib.waits(driver,20);
	// pom page
	TmsHomePage tmp=new TmsHomePage(driver);
	tmp.admin();
	AdminLoginPage alp=new AdminLoginPage(driver);
	alp.login(Username,Password);
	AdminDashboardPage adp=new AdminDashboardPage(driver);
    adp.tourpack(driver);
    //fetching the data from the excel Sheet
    eLib.getMultipleExcelData("Sheet1", 0, 1, "CREATE", driver);
    AdminCreateTourPackagepage actp=new AdminCreateTourPackagepage(driver);
   // actp.createTour("Holiday","Family","Dubai","4000","Food and accomadation","Safety and secure");
    wLib.scrollBarAction(driver);
    File f=new File(".//src/test/resources/WhatsApp Image 2023-07-13 at 4.36.15 PM.jpeg");
    String abpath = f.getAbsolutePath();
    actp.packageImage(abpath);
    Thread.sleep(1000);
    wLib.scrollBarAction(driver);
    actp.createPackage();
    Thread.sleep(1000);
    actp.successMsg("SUCCESS");
	}
	}