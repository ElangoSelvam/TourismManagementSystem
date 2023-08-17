package com.tourism.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.tms.GenericUtility.FileUtililty;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.ObjectRepository.TmsHomePage;
import com.tms.ObjectRepository.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteusToIssueTicketsTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
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
		UserHomePage uhp=new UserHomePage(driver);
		uhp.writeUs();
		uhp.issueBtn();
		uhp.describtion("I have a booking issue");
		uhp.confirmMsg("Confirmation");
		uhp.issueTicket();
		uhp.cancelConfirm("I have a booking issue");
		driver.quit();
	}

}













/*FileInputStream fis=new FileInputStream(".//src/test/resources/TmsCommondata.properties");
Properties p=new Properties();
p.load(fis);
String url = p.getProperty("url");
String browser = p.getProperty("browser");
String un1 = p.getProperty("username1");
String pw = p.getProperty("password");
WebDriver driver;
		
		//Launching the browser
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(un1);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']//following-sibling::input")).sendKeys(pw);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//a[text()=' / Write Us ']")).click();
		WebElement select = driver.findElement(By.name("issue"));
		Select s=new Select(select);
		s.selectByIndex(1);
		driver.findElement(By.name("description")).sendKeys("I have a booking issue problem");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//driver.findElement(By.xpath("//a[text()='Issue Tickets']")).click();
*/
