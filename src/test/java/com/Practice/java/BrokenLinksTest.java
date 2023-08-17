package com.Practice.java;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/tour-history.php");
		List<WebElement> listLinks = driver.findElements(By.xpath("//a"));
		System.out.println(listLinks.size());
		ArrayList<String> arraylist=new ArrayList<String>();
		for(int i=0;i<listLinks.size();i++) {
			String eachlink = listLinks.get(i).getAttribute("href");
			URL url=null;
			int statuscode=0;
			try {
			url=new URL(eachlink);
			HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
			statuscode=httpURLConnection.getResponseCode();
			if(statuscode>=200) {
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

