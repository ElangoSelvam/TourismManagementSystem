package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.GenericUtility.WebDriverUtility;

public class AdminDashboardPage {
	// Declaring the WebElements
	@FindBy(xpath="//i[@class='fa fa-angle-down']")
	private WebElement scrollBtn;
	@FindBy(xpath="//a[@href='change-password.php']")
	private WebElement profileBtn;
	@FindBy(xpath="//a[text()=' Logout']")
	private WebElement logoutBtn;
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeBtn ;
	@FindBy(xpath="//span[text()=' Tour Packages']")
	private WebElement tourBtn;
	@FindBy(xpath="//a[text()='Create']")
	private WebElement createBtn;
	@FindBy(xpath="//a[text()='Manage']")
	private WebElement manageBtn;
	@FindBy(xpath="//span[text()='Manage Booking']")
	private WebElement managebookBtn;
	
	// Initializing the WebElements
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	// Utilizing the WebElements
	public WebElement getScrollBtn() {
		return scrollBtn;
	}
	public WebElement getProfileBtn() {
		return profileBtn;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public WebElement getHomeBtn() {
		return homeBtn;
	}
	public WebElement getTourBtn() {
		return tourBtn;
	}
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public WebElement getManagebookBtn() {
		return managebookBtn;
	}

	WebDriverUtility wlib=new WebDriverUtility();
	// Business Libraries
	public void profile() {
		scrollBtn.click();
		profileBtn.click();
}
	public void logout() {
		scrollBtn.click();
		logoutBtn.click();
	}
	
	public void tourpack(WebDriver driver) {
		tourBtn.click();
		wlib.mouseHover(driver, createBtn);	
        
	}
	public void tourpackman(WebDriver driver) {
		tourBtn.click();
		wlib.mouseHover(driver, manageBtn);
	}
	public void managebookBtn() {
		managebookBtn.click();
	}
	
	
	

}
