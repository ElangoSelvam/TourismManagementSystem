package com.tms.GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.tms.ObjectRepository.AdminDashboardPage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.TmsHomePage;
import com.tms.ObjectRepository.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtililty fLib=new FileUtililty();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
public WebDriver driver;
public static WebDriver sdriver;
@BeforeSuite(alwaysRun = true)
public void ConnectDB() throws SQLException {
           dLib.connectToDataBase();
          System.out.println("Connect to DataBase");
}
//@Parameters("Browser")
@BeforeClass(alwaysRun = true)

public void launchBrowser() throws Throwable {
	  String Browser = fLib.getPropertyData("browser");
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
	  sdriver=driver;
	
	System.out.println("Launch the Browser");
	wLib.windowMaximize(driver);
}

@BeforeMethod(alwaysRun = true)
	public void loginApp() throws Throwable {
		 String Url= fLib.getPropertyData("url");
		 // User Credentials
		// String Username1= fLib.getPropertyData("username1");
	     // String Password= fLib.getPropertyData("password");	
		 // Admin Credentials
		 String Username= fLib.getPropertyData("username");
	     String Password= fLib.getPropertyData("password");
	     driver.get(Url);
	     wLib.waits(driver, 10);
	     
	     TmsHomePage thp=new TmsHomePage(driver);
	    // thp.loginUser(driver, Username1, Password);
	     // Admin Login credentials
	     thp.admin();
	     AdminLoginPage alp=new AdminLoginPage(driver);
	     alp.login(Username, Password);
	     System.out.println("Login to the app");
		
	}
@AfterMethod(alwaysRun = true)
	public void  logoutApp() {
	wLib.scrollUpAction(driver);
	//User Logout
	//UserHomePage uhp=new UserHomePage(driver);
	//uhp.logout();
		// Admin Logout
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.logout();
		System.out.println("Logout the app");
		
	}
	
@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("Close the Browser");
	}
@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException {
	dLib.closeDataBase();
		System.out.println("Close the DataBase");
		
	}
	
	
	
	
	
	
	
	
}
