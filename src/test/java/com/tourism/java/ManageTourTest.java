package com.tourism.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.FileUtililty;
import com.tms.GenericUtility.JavaUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.ObjectRepository.AdminDashboardPage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminManageTourpackagePage;
import com.tms.ObjectRepository.TmsHomePage;
import com.tms.ObjectRepository.UpdateTourPackagePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageTourTest {
		public static void main(String[] args) throws Throwable {
			    // Utility objects
				WebDriverUtility wLib=new WebDriverUtility();
				FileUtililty fLib=new FileUtililty();
				// FileUtility  
				WebDriver driver;
		        String Browser= fLib.getPropertyData("browser");
		        String Url= fLib.getPropertyData("url");
		        String Username= fLib.getPropertyData("username");
		        String Password= fLib.getPropertyData("password");
				if(Browser.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					
				}
				else if(Browser.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else {
					driver=new ChromeDriver();
				}
				// Enter the Url
				driver.get(Url);
				// Maximize the Window
				wLib.windowMaximize(driver);
				// Waiting condition
				wLib.waits(driver, 10);
				// Pom Page Objects
				TmsHomePage tmp=new TmsHomePage(driver);
				AdminLoginPage alp=new AdminLoginPage(driver);
				AdminDashboardPage adp=new AdminDashboardPage(driver);
				AdminManageTourpackagePage amtp=new AdminManageTourpackagePage(driver);
				UpdateTourPackagePage utp=new UpdateTourPackagePage(driver);
				tmp.admin();
				alp.login(Username, Password);
				adp.tourpackman(driver);
				amtp.details();
		        utp.packageNameUt("America"); 
		        wLib.scrollBarAction(driver);
		        utp.submitBtn();
		        utp.succesMsg("SUCCESS");
		        driver.quit();
			    }

	            }


	
