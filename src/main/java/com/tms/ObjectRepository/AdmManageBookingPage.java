package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdmManageBookingPage {
	// Declaring the WebElements
	@FindBy(xpath="//h2[text()='Manage Bookings']")
	private WebElement managebook;

    // Intializing the WebElements
    public AdmManageBookingPage(WebDriver driver) {
    PageFactory.initElements(driver,this);	
    }
    // Utilizing the WebElements
    
    public WebElement getManageBook() {
    	return managebook;
    }
    
    // Business Library
    public void managebook(String expdata) {
		String actual=managebook.getText();
		Assert.assertEquals(actual, expdata,"Manage booking succesfully");
//		if(success.contains(expdata)) {
//			System.out.println("Manage booking succesfully");
//		}
//		else {
//			System.out.println("Manage booking not created");
//		}
	}  
    
}