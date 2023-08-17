package com.Practice.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyUrlAssertTest {
	
//	@Test
//	public void verify() {
//		String expect="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.flipkart.com/");
//		String actual = driver.getTitle();
//		Assert.assertEquals(actual,expect);
//		System.out.println("Sccessfully verified");
//		
//	}
@Test
public void verifyApp() {
	String expect="TMS | Tourism Management System";
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
	String actual = driver.getTitle();
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(actual, expect,"Sccessfully verified");
	//Assert.assertEquals(actual,expect);
	//System.out.println("Sccessfully verified");
	sa.assertAll();
}
}
