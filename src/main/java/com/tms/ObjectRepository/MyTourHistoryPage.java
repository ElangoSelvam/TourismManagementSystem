package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyTourHistoryPage {

@FindBy(xpath="//table/tbody/tr[last()]/td/a[text()='Cancel']")
private WebElement tableCanBtn;
@FindBy(xpath="//strong[text()='SUCCESS']")
private WebElement successMsg;



public MyTourHistoryPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	
	
}



public WebElement getTableBtn() {
	return tableCanBtn;
}
public WebElement getErrorMsg() {
	return successMsg;
}
public void tourHistoryPage() {
	tableCanBtn.click();
	
}
public void successMsg(String expected) {
	String actual = successMsg.getText();
	Assert.assertEquals(actual, expected,"Cancel Booking SuccessFully");
//	if(actual.contains(expected)) {
//		System.out.println("Cancel Booking SuccessFully");
//	}
//	else {
//		System.out.println("Booking not canceled Succesfully");
//	}
}

}
