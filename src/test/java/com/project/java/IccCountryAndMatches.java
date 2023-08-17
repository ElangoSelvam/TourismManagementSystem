package com.project.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.List;

public class IccCountryAndMatches {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the ICC T20I Men's Team Rankings page
        driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");

        try {
            // Wait for a few seconds for the page to load (You may need to adjust the wait time as per your internet speed)
            Thread.sleep(5000);

            // Find the table element that contains the team rankings
            WebElement table = driver.findElement(By.xpath("//table[@class='table']"));

            // Find all rows in the table
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            // Print the team and matches columns where matches is greater than 30
            for (int i = 1; i < rows.size(); i++) {
                List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

                // Extract the relevant data from the columns
                String team = columns.get(1).getText();
                String matches = columns.get(2).getText();

                try {
                    int matchesPlayed = Integer.parseInt(matches);

                    // Check if matches played is greater than 30
                    if (matchesPlayed > 30) {
                        // Print the data in the specified format
                        System.out.println("Team: " + team + ", Matches Played: " + matchesPlayed);
                    }
                } catch (NumberFormatException e) {
                    // Handle the NumberFormatException here (e.g., log, ignore, or handle it in a custom way)
                    System.err.println("Error parsing matches for team: " + team + " | Matches: " + matches);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}