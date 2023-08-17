package com.Practice.java;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class PropertyFileDataTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".//src/test/resources/TmsCommondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(un);
		System.out.println(pw);
        
	    WebDriver driver;
	
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
		int date = 12;
		int date1= 16;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//sign in to the application
		driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']//following-sibling::input")).sendKeys(pw);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		//Booking the tour package
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
	    driver.findElement(By.name("todate")).click();
	    driver.findElement(By.xpath("//a[text()='"+date1+"']")).click();
	    driver.findElement(By.name("comment")).sendKeys("Customer package booked");
	    driver.findElement(By.xpath("//button[text()='Book']")).click();
	
	}
	
}