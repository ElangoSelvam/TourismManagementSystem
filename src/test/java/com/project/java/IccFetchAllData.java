package com.project.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccFetchAllData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Set the path to your ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to Amazon web
        driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
        
        try {
            // Wait for a few seconds for the page to load (You may need to adjust the wait time as per your internet speed)
            Thread.sleep(5000);

            // Find the table element that contains the team rankings
            WebElement table = driver.findElement(By.xpath("//table[@class='table']"));

            // Find all rows in the table
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            // Print the data from each row
            for (int i = 1; i < rows.size(); i++){
                List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
                String rank = columns.get(0).getText();
                String team = columns.get(1).getText();
                String matches = columns.get(3).getText();
                String points =columns.get(3).getText();
                String ratings =columns.get(0).getText();
                System.out.println("position="+rank+"------>"+"Team="+team+"----->"+"Matches="+matches+"----->"+"Points"+points+"------>"+"Ratings"+ratings);
          
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
           
        }
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
/*for (WebElement column : columns) {
    System.out.print(column.getText() + "\t");
}
System.out.println();
}*/
        
        
 
       //WebElement Match = driver.findElement(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[@class='rankings-block__banner--matches']"));
       
        //String allTeams = driver.findElement(By.xpath("//span[text()='India']/../..")).getText();
       // ArrayList<String> array=new ArrayList<String>();
	//int count=allTeams.size();
	//System.out.print(allTeams);
	
	/*for(int i=0;i<=allTeams.size();i++) {
		String team=allTeams.get(i).getText();
		System.out.println(team);
		
	}*/
	
	
		
		
		
		


