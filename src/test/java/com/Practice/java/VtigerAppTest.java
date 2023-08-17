package com.Practice.java;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerAppTest {

	public static void main(String[] args) throws InterruptedException {
		String MonthAndYear="July 2023";
		int date=21;
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		//driver.findElement(By.xpath("//div[text()='July 2023']/ancestor::div[@class='DayPicker-Months']/descendent::p[text()='21']")).click();
	String	actualdate="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']";
		
String nextArrow="//span[@aria-label='Next Month']";
for(;;) {
	try {
		driver.findElement(By.xpath("actualdate")).click();
		break;
	}

	catch (Exception e) {
		driver.findElement(By.xpath(nextArrow)).click();
	}
	
}
      Thread.sleep(1000);

      driver.findElement(By.xpath("//span[text()='Done']")).click();
      driver.close();
	}

}
//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='28']