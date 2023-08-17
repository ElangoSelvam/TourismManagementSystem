package com.project.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccFirstTenCountry {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();

	        // Navigate to Amazon web
	        driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		// TODO Auto-generated method stub

		try {
            // Wait for a few seconds for the page to load (You may need to adjust the wait time as per your internet speed)
            Thread.sleep(5000);

            // Find the table element that contains the team rankings
            WebElement table = driver.findElement(By.xpath("//table[@class='table']"));

            // Find all rows in the table
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            // Print the first 10 team names
            for (int i = 1; i < Math.min(11, rows.size()); i++) {
                List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

                // Extract the team name from the second column (index 1)
                String team = columns.get(1).getText();

                // Print the team name
                System.out.println("Team: " + team);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
		
		
		

