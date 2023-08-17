package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy(xpath="//a[text()='Details']")
	private WebElement detailsBtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getDetailBtn() {
		return detailsBtn;
	}
	public void detailsBtn() {
		detailsBtn.click();
	}

}
