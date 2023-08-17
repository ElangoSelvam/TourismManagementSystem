package com.Practice.java;

/*import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraBrokenLinks {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://example.com");
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	for(WebElement link:links) {
		String eachLink = link.getAttribute("href");
		 if (eachLink != null && !eachLink.isEmpty()) {
		try {
			URL url=new URL(eachLink);
			HttpURLConnection httpConnection=(HttpURLConnection)url.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.connect();
			//Get the response code
			int responsecode=httpConnection.getResponseCode();
			//check if the response code indicate the broken link
			if(responsecode==200) {
				System.out.println(url+"Valid link");
			}
			//httpConnection.disconnect();
			else {
				System.out.println(url+"Invalid link");
			}
		}
			catch(Exception e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
		 }
			}
	//Close the Browser
driver.close();
}
}*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MyntraBrokenLinksTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a ChromeOptions object to disable the browser window
    	WebDriverManager.chromedriver().setup();
       // ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--headless"); // Uncomment this line to run the tests without displaying the browser window
        WebDriver driver = new ChromeDriver();

        // Navigate to the web page you want to test
        driver.get("https://www.instagram.com/");

        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Loop through the links and validate their status codes
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    int statusCode = connection.getResponseCode();
                    if (statusCode >=100) {
                        System.out.println(url + " is a valid link.");
                    } else {
                        System.out.println(url + " is a broken link with status code: " + statusCode);
                    }
                } catch (Exception e) {
                    System.out.println(url + " is a broken link. Exception: " + e.getMessage());
                }
            }
        }

        // Close the browser
        driver.close();
    }
}
  
