package com.project.java;
import java.util.List;
import java.awt.AWTException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIphone {

	public static void main(String[] args) throws AWTException {
		
	
		        // Set the path to your ChromeDriver executable
		        WebDriverManager.chromedriver().setup();
		        WebDriver driver = new ChromeDriver();

		        // Navigate to Amazon web
		        driver.get("https://www.amazon.in/");

		        // Find the search bar and enter "iPhone" as the search query
		        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		        searchBox.sendKeys("iPhone");
		        searchBox.submit();

		        // Wait for the search results to load
		        try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		        // Find all the product names and prices on the page
		       List<WebElement> productNames = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		       List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
    
		        // Print the names and prices of the products
		        for (int i = 0; i < productNames.size(); i++) {
		            String productName = productNames.get(i).getText();
		            String productPrice = productPrices.get(i).getText();
		            System.out.println("Product Name: " + productName);
		            System.out.println("Product Price: " + productPrice);
		            System.out.println("-------------------------");
		        }

		        // Close the browser
		        driver.quit();
		    }
		}
		


































		
		
//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']
		
		
		// TODO Auto-generated method stub
/*WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
Robot r=new Robot();
r.keyPress(KeyEvent.VK_ENTER);*/
//span[@class='a-size-medium a-color-base a-text-normal']

	
