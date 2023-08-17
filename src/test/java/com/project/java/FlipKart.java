package com.project.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
  
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");

        // Find the search bar and enter "iPhone" as the search query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("samsung");
        searchBox.submit();

        // Wait for the search results to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find all the product names and prices on the page
       List<WebElement> productNames = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
       List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='_30jeq3']"));

        // Print the names and prices of the products
        for (int i = 0; i < productNames.size(); i++) {
            String productName = productNames.get(i).getText();
            String productPrice = productPrices.get(i).getText();
            System.out.println("Product Name: " + productName);
            System.out.println("Product Price: " + productPrice);
            System.out.println("--------------M-----------");
        }

        // Close the browser
        driver.quit();
    }

	}


