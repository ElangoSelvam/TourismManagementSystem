package com.tourism.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.FileUtililty;
import com.tms.GenericUtility.JavaUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.MyTourHistoryPage;
import com.tms.ObjectRepository.PackageDetailsPage;
import com.tms.ObjectRepository.TmsHomePage;
import com.tms.ObjectRepository.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookAndCancelTest {

	public static void main(String[] args) throws Throwable {
		//Object Creation for Utility 
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtililty fLib=new FileUtililty();
		// Fetching the data from File Utility Class
        String Browser= fLib.getPropertyData("browser");
        String Url= fLib.getPropertyData("url");
        String Username1= fLib.getPropertyData("username1");
        String Password= fLib.getPropertyData("password");				
	    WebDriver driver;
		if
		(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		}
		// Launch the url
		driver.get(Url);
		// Maximize the Window
		wLib.windowMaximize(driver);
		// Wait for some  time to find the element
		wLib.waits(driver, 10);
		//login to app
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
		UserHomePage uhp=new UserHomePage(driver);
		uhp.tourHistory();
		//Cancel the Tour package 
		MyTourHistoryPage mth=new MyTourHistoryPage(driver);
		mth.tourHistoryPage();
		wLib.acceptAlert(driver);
		mth.successMsg("SUCCESS");
				
		
	}

}








//FileInputStream fis=new FileInputStream(".//src/test/resources/TmsCommondata.properties");
//Properties pObj=new Properties();
//pObj.load(fis);
//String URL = pObj.getProperty("url1");
//String BROWSER = pObj.getProperty("browser");
//String USERNAME = pObj.getProperty("username");
//String PASSWORD = pObj.getProperty("password");driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
/*driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(Username1);
driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
driver.findElement(By.name("signin")).click();
driver.findElement(By.xpath("//a[text()='Details']")).click();
wLib.scrollBarAction(driver);
driver.findElement(By.id("datepicker")).click();
driver.findElement(By.xpath("//a[text()='29']")).click();
driver.findElement(By.id("datepicker1")).click();
driver.findElement(By.xpath("//a[text()='31']")).click();
wLib.scrollBarAction(driver);
driver.findElement(By.name("comment")).sendKeys("welcome");
driver.findElement(By.xpath("//button[text()='Book']")).click();

String expResult="Booked Successfully ";
WebElement actResult = driver.findElement(By.xpath("//div[text()=':Booked Successfully ']"));
String text = actResult.getText();
if(expResult.contains(text)) {
	System.out.println("Booking not successfull");
}
else {
	System.out.println("Booking successful");
}
//driver.findElement(By.xpath("//a[text()='My Tour History']")).click();
				//driver.findElement(By.xpath("//table/tbody/tr[last()]/td/a[text()='Cancel']")).click();
				//driver.switchTo().alert().accept();*/
