package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TmsHomePage {
	  // Declaring the WebEements
	 //  This is for admin button
		@FindBy(xpath="//a[text()='Admin Login']")
		private WebElement adminbtn;
		
		// This is for sign in button 
		@FindBy(xpath="//a[text()='/ Sign In']")
		private WebElement userbtn;
		@FindBy(xpath="//input[@placeholder='Enter your Email']")
		private WebElement emailbtn ;
		@FindBy(xpath="//input[@placeholder='Enter your Email']//following-sibling::input")
		private WebElement passwordbtn ;
		@FindBy(xpath="//a[text()='Forgot password']")
		private WebElement forgotbtn ;
		@FindBy(xpath="//input[@value='SIGNIN']")
		private WebElement loginbtn;
		@FindBy(xpath="//a[text()='Home']")
		private WebElement homeBtn;
		
		
		
		
		//This is for sign up Button
		@FindBy(xpath="//a[text()='Sign Up']")
		private WebElement signupbtn;
		
		
		
		
		// Initializing the WebElements
		public TmsHomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			
		}
     
		// Utilizing the WebElements
		public WebElement getAdminbtn() {
			return adminbtn;
		}




		public WebElement getUserbtn() {
			return userbtn;
		}




		public WebElement getEmailbtn() {
			return emailbtn;
		}




		public WebElement getPasswordbtn() {
			return passwordbtn;
		}




		public WebElement getForgotbtn() {
			return forgotbtn;
		}




		public WebElement getLoginbtn() {
			return loginbtn;
		}




		public WebElement getSignupbtn() {
			return signupbtn;
		}
		public WebElement getHomeBtn() {
			return homeBtn;
		}
	
		
		
	// Business llibrary
		
		
		public void admin() {
			adminbtn.click();
		}
		
		public void loginUser(WebDriver driver,String USERNAME,String PASSWORD) {
			userbtn.click();
			emailbtn.sendKeys(USERNAME);
			passwordbtn.sendKeys(PASSWORD);
			loginbtn.click();
		}
		public void homeBtn() {
			homeBtn.click();
		}
		
		
	

}
