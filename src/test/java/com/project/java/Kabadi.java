package com.project.java;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kabadi {
	public static void main(String[] args) throws AWTException {
		
		
        // Set the path to your ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to Amazon web
        driver.get("https://www.prokabaddi.com/standings");
        ArrayList<String> array=new ArrayList<String>();
        List<WebElement> allTeams = driver.findElements(By.xpath("//p[@class='name']/../../../parent::div"));
	int count=allTeams.size();
	for(int i=0;i<=allTeams.size();i++) {
		String team=allTeams.get(i).getText();
		array.add(team);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}	
	
}
