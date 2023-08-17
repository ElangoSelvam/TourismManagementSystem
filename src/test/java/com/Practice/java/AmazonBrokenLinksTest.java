package com.Practice.java;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBrokenLinksTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub https://www.amazon.com/
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		// Find all the links on the page
		List<WebElement> amazonLinks = driver.findElements(By.xpath("//a"));
		System.out.println(amazonLinks.size());
		ArrayList<String> arraylist=new ArrayList<String>();
		  // Iterate through each link and check for broken links
		for(int i=0;i<amazonLinks.size();i++) {
			String eachlink = amazonLinks.get(i).getAttribute("href");
			URL url=null;
			int statuscode=0;
			try {
				 // Open a connection to the URL
			url=new URL(eachlink);
			HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
			 // Get the response code
			statuscode=httpURLConnection.getResponseCode();
			   // Check if the response code indicates a broken link
			if(statuscode>=400) {
				arraylist.add(eachlink+"----->"+statuscode);
			}
			}
			catch(Exception e) {
				arraylist.add(eachlink+"----->"+statuscode);
			}
		}
		System.out.println(arraylist);


	}

}
