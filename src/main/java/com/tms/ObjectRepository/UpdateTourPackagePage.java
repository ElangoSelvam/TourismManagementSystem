package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UpdateTourPackagePage {
	// Declaring the WebElements
	@FindBy(id="packagename")
    private WebElement pckgnameBtn;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath="//strong[text()='SUCCESS']")
	private WebElement succesMsg;
	 // Initializing the WebElements
    public UpdateTourPackagePage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
     
	// Utilizing the WebElements
 	public WebElement getPckgnameBtn() {
 		return pckgnameBtn;
 	}
 	public WebElement getSubmitBtn() {
 		return submitBtn;
 		
 	}
 	public WebElement getSuccesMsg() {
 		return succesMsg;
 	}
 	// Business Library
 	public void packageNameUt(String value) {
 		pckgnameBtn.clear();
 		pckgnameBtn.sendKeys(value);
 	}
 	public void submitBtn() {
 		submitBtn.click();
 	}
 	public void succesMsg(String Expdata) {
 		String actual=succesMsg.getText();
 		Assert.assertEquals(actual, Expdata,"Package has been created succesfully");
// 		if(success.contains(Expdata)) {
// 			System.out.println("Package has been created succesfully");
// 			}
// 		else {
// 			System.out.println("Pacakge not created");
// 		}
 	}
	

}
