package com.Practice.java;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleBrokenLinksTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
       WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        // Navigate to the webpage you want to check for broken links
        driver.get("https://www.deadlinkchecker.com/");

        // Find all the links on the page
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println(links.size());
        // Iterate through each link and check for broken links
     
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            try {
                // Open a connection to the URL
                URL linkUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Get the response code
                int responseCode = connection.getResponseCode();

                // Check if the response code indicates a broken link
                if (responseCode >= 400) {
                    System.out.println("Broken link found: " + url);
                }

                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Quit the WebDriver
        driver.quit();
    

	}

}
