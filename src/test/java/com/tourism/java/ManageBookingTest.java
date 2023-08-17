package com.tourism.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.GenericUtility.BaseClass;
import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.FileUtililty;
import com.tms.GenericUtility.JavaUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.ObjectRepository.AdmManageBookingPage;
import com.tms.ObjectRepository.AdminDashboardPage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.TmsHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageBookingTest extends BaseClass{

	public void manageTour() throws Throwable {
		// Object creation for Utility Class
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtililty fLib=new FileUtililty();
	    WebDriver driver;
	    WebDriverManager.chromedriver().setup();
        String Browser= fLib.getPropertyData("browser");
        String Url= fLib.getPropertyData("url");
        String Username= fLib.getPropertyData("username");
        String Password= fLib.getPropertyData("password");

		//Launching the browser
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
		// Waiting conditon for find the  elements
		wLib.waits(driver, 10);
		// Pom Page Class
		TmsHomePage tmp=new TmsHomePage(driver);
		tmp.admin();
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.login(Username, Password);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.managebookBtn();
		AdmManageBookingPage ambp=new AdmManageBookingPage(driver);
		ambp.managebook("Manage Bookings");
		driver.close();
        }
        }











//FileInputStream fis=new FileInputStream(".//src/test/resources/TmsCommondata.properties");
//Properties p=new Properties();
//p.load(fis);
//String url = p.getProperty("url");
//String browser = p.getProperty("browser");
//String un = p.getProperty("username");
//String pw = p.getProperty("password");

//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
//driver.findElement(By.name("username")).sendKeys(Username);
//driver.findElement(By.xpath("//input[@class='password']")).sendKeys(Password);
//driver.findElement(By.xpath("//input[@type='submit']")).click();
//String expectedResult="Manage Booking";
//WebElement text_Name = driver.findElement(By.xpath("//span[text()='Manage Booking']"));
//String actualResult = text_Name.getText();
//System.out.println(actualResult);
//if(expectedResult.equals(actualResult)) {
//	System.out.println("Manage Booking Successfully");
//}
//else {
//System.out.println("Manage Booking failed");
//}
//String text = driver.findElement(By.xpath("//h2[text()='Manage Bookings']")).getText();
//System.out.println(text);
