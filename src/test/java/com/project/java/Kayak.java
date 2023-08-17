package com.project.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kayak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Set the path to your ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        // Create an instance of WebDriver (open Chrome browser)
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-origin']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@placeholder='To?']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
