package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
    // Declaring the WebEements
	
	@FindBy(name="username")
	private WebElement usernameBtn;
	
	@FindBy(xpath="//input[@class='password']")
	private WebElement passwordBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	@FindBy(xpath="//a[text()='Back to home']")
	private WebElement backBtn;
	// Initializing the WebElements
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	// Utilizing the WebElements
	
	public WebElement getUsernameBtn() {
		return usernameBtn;
	}


	public WebElement getPasswordBtn() {
		return passwordBtn;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}


	public WebElement getBackBtn() {
		return backBtn;
	}
	
	// Business Libraries
	
	public void login(String Username,String Password) {
		usernameBtn.sendKeys(Username);
		passwordBtn.sendKeys(Password);
		loginBtn.click();
	}





	
}
