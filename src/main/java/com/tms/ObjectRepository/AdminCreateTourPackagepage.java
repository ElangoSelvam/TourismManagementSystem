package com.tms.ObjectRepository;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminCreateTourPackagepage {
	//  Declaring the webElements
    @FindBy(id="packagename")
    private WebElement pckgnamebtn;
    @FindBy(id="packagetype")
    private WebElement pckgtypebtn;
    @FindBy(id="packagelocation")
    private WebElement pckglocbtn;
    @FindBy(id="packageprice")
    private WebElement pckgpricebtn;
    @FindBy(id="packagefeatures")
    private WebElement pckgfeatutresbtn;
    @FindBy(id="packagedetails")
    private WebElement pckgdetailsbtn;
    @FindBy(id="packageimage")
    private WebElement pckgimagebtn;
    @FindBy(xpath="//button[text()='Create']")
    private WebElement createbtn;
    @FindBy(xpath="//button[@type='reset']")
    private WebElement resetbtn;
    @FindBy(xpath="//strong[text()='SUCCESS']")
    private WebElement successMsg;
 
    // Initializing the WebElements
    public AdminCreateTourPackagepage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
    // Utilizing the WebElements
	public WebElement getPckgnamebtn() {
		return pckgnamebtn;
	}
	public WebElement pckgtypebtn() {
		return pckgtypebtn;
	}
	public WebElement getPckglocbtn() {
		return pckglocbtn;
	}
	public WebElement getPckgpricebtn() {
		return pckgpricebtn;
	}
	public WebElement getPckgfeatutresbtn() {
		return pckgfeatutresbtn;
	}
	public WebElement getPckgdetailsbtn() {
		return pckgdetailsbtn;
	}
	public WebElement getPckgimagebtn() {
		return pckgimagebtn;
	}
	public WebElement getCreatebtn() {
		return createbtn;
	}	
	public WebElement getSuccessMsg() {
		return successMsg;
		
	}
	// Business libraries
	public void packageImage(String path) {
		pckgimagebtn.sendKeys(path);
	}
	public void successMsg(String expdata) {
		
		String actual=successMsg.getText();
	    Assert.assertEquals(actual, expdata,"Package has been created successfully");

//if(success.contains("SUCCESS")) {
//	System.out.println("Package has been created succesfully");
//	}
//else {
//	System.out.println("Pacakge not created");
//}
	}
	public void createTour(String Name,String Type,String Loc,String Price,String Feauture,String Details) {
		pckgnamebtn.sendKeys(Name);
		pckgtypebtn.sendKeys(Type);
		pckglocbtn.sendKeys(Loc);
		pckgpricebtn.sendKeys(Price);
		pckgfeatutresbtn.sendKeys(Feauture);
		pckgdetailsbtn.sendKeys(Details);	
}
	public void clickImg() {
		pckgimagebtn.click();
	}
	public void createPackage() {
		createbtn.click();
	
	}
	public void createTour(WebDriver driver,int random,HashMap<String,String> hs) {
		for(Entry<String, String> set:hs.entrySet()) {
			if(set.getKey().contains("packagename")) {
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue()+random);
		}  
		else {
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
		
	}
	}
	
	
	
}
