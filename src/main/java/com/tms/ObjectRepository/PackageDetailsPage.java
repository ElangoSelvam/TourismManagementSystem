package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PackageDetailsPage {
      
	private static final int date = 3;
	private static final int date1 = 7;
	@FindBy(id="datepicker")
	private WebElement dateClick;
	@FindBy(xpath="//a[text()='"+date+"']")
	private WebElement selectDate;
	@FindBy(name="todate")
	private WebElement todateClick;
	@FindBy(xpath="//a[text()='"+date1+"']")
	private WebElement selectDates;
	@FindBy(name="comment")
    private WebElement comments;
	@FindBy(xpath="//button[text()='Book']")
	private WebElement bookBtn;
	@FindBy(xpath="//strong[text()='SUCCESS']")
	private WebElement successBtn;
	
	public PackageDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public static int getDate() {
		return date;
	}

	public static int getDate1() {
		return date1;
	}

	public WebElement getDateClick() {
		return dateClick;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}

	public WebElement getTodateClick() {
		return todateClick;
	}

	public WebElement getSelectDates() {
		return selectDates;
	}

	public WebElement getComments() {
		return comments;
	}

	public WebElement getBookBtn() {
		return bookBtn;
	}
	public WebElement getSuccessBtn() {
		return successBtn;
		
	}
	
	public void SelcetDate() {
		dateClick.click();
		selectDate.click();
		todateClick.click();
		selectDates.click();
	}
	public void comment(String text) {
		comments.sendKeys(text);
	}
	public void bookbtn() {
		bookBtn.click();
	}
	public void successBtn(String expdata) {
		String actual=successBtn.getText();
		//Assert.assertEquals(actual, expdata,"Package has been created successfully");
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(actual, expdata,"Package has been created successfully");
		sa.assertAll();
//		if(actual.contains(expdata)) {
//			System.out.println("Package has created successfully");
//		}
//		else {
//			System.out.println("Package has not created");
//		}
	}
	
	
	
}
