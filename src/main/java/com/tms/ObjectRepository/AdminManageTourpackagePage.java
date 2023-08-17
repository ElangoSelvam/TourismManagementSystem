package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminManageTourpackagePage {
	// Declaring the  WebElements
	@FindBy(xpath="//button[@type='button']")
	private WebElement detailsBtn;
	// Initializing the WebElements
	public AdminManageTourpackagePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    // Declaring the WebElements
	public WebElement getDetailsBtn() {
		return detailsBtn;
	}
	// Business Libraries
	public void details() {
		detailsBtn.click();
	}
}
