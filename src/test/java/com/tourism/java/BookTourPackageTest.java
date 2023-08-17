package com.tourism.java;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.FileUtililty;
import com.tms.GenericUtility.JavaUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.PackageDetailsPage;
import com.tms.ObjectRepository.TmsHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookTourPackageTest {

	public static void main(String[] args) throws Throwable {
		// Object Creation for utility class
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtililty fLib=new FileUtililty();
		// Fetching the data from the File Utility Class
        String Browser= fLib.getPropertyData("browser");
        String Url= fLib.getPropertyData("url");
        String Username1= fLib.getPropertyData("username1");
        String Password= fLib.getPropertyData("password");
        WebDriver driver;
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
        //Enter the Url
		driver.get(Url);
		// Maximize the Window
		wLib.windowMaximize(driver);
		// Waiting condition
		wLib.waits(driver, 10);
		//sign in to the application
		TmsHomePage tms=new TmsHomePage(driver);
		tms.loginUser(driver, Username1, Password);
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









// TODO Auto-generated method stub
// TODO Auto-generated method stub
//FileInputStream fis=new FileInputStream(".//src/main/resources/TmsCommondata.properties");
//Properties p=new Properties();
//p.load(fis);
//String url = p.getProperty("url");
//String browser = p.getProperty("browser");
//String un = p.getProperty("username");
//String pw = p.getProperty("password");
//System.out.println(url);
//System.out.println(browser);
//System.out.println(un);
//System.out.println(pw);
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
//
//driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(Username1);
//driver.findElement(By.xpath("//input[@placeholder='Enter your Email']//following-sibling::input")).sendKeys(Password);
//driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
//driver.findElement(By.xpath("//a[text()='Home']")).click();
//driver.findElement(By.xpath("//a[text()='Details']")).click();
//driver.findElement(By.id("datepicker")).click();
//driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
//driver.findElement(By.name("todate")).click();
//driver.findElement(By.xpath("//a[text()='"+date1+"']")).click();
//wLib.scrollBarAction(driver);
//driver.findElement(By.name("comment")).sendKeys("Customer package booked");
//driver.findElement(By.xpath("//button[text()='Book']")).click();
//
//
//
//
//
//
//