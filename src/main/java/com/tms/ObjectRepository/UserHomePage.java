package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tms.GenericUtility.WebDriverUtility;

public class UserHomePage {
    // Declaring the WeblElements
	@FindBy(xpath="//a[text()='/ Logout']")//a[text()='Issue Tickets']
	private WebElement logoutbtn;
	@FindBy(xpath="//a[text()='Issue Tickets']")
	private WebElement issuetickbtn;
	@FindBy(xpath="//a[text()='My Tour History']")
	private WebElement historybtn;
	@FindBy(xpath="//a[text()='Change Password']")
    private WebElement 	chngpwdbtn;
	@FindBy(xpath="//a[text()='My Profile']")
	private WebElement profilebtn;
	@FindBy(xpath="//a[text()=' / Write Us ']")
    private WebElement writebtn;
	@FindBy(xpath="//a[text()='Tour Packages']")
	private WebElement Tourbtn;
	@FindBy(xpath="//a[text()='Details']")
	private WebElement detailsbtn;
	// Write us popup window WebElements
	@FindBy(name="issue")
	private WebElement issuebtn;
	@FindBy(name="description")
	private WebElement discribebtn;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbtn;
	@FindBy(xpath="//h3[text()=' Confirmation']")
	private WebElement confirmMsg;
	@FindBy(xpath="//table//tbody//tr[last()]/td[4]")
	private WebElement confirmcancel;
	
	
	
	//Initializing the WebElements
	public UserHomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	//Utilizing the WebElements



	public WebElement getLogoutbtn() {
		return logoutbtn;
	}



	public WebElement getIssuetickbtn() {
		return issuetickbtn;
	}



	public WebElement getHistorybtn() {
		return historybtn;
	}



	public WebElement getChngpwdbtn() {
		return chngpwdbtn;
	}



	public WebElement getProfilebtn() {
		return profilebtn;
	}



	public WebElement getWritebtn() {
		return writebtn;
	}



	public WebElement getTourbtn() {
		return Tourbtn;
	}



	public WebElement getDetailsbtn() {
		return detailsbtn;
	}



	public WebElement getIssuebtn() {
		return issuebtn;
	}



	public WebElement getDiscribebtn() {
		return discribebtn;
	}



	public WebElement getSubmitbtn() {
		return submitbtn;
	}

public WebElement getConfirmMsg() {
	return confirmMsg;
}

public WebElement getConfirmcancel() {
	return confirmcancel;
}

 // Object for WebUtility
	WebDriverUtility wLib=new WebDriverUtility();
public void tourHistory() {
	historybtn.click();
}
public void writeUs() {
	writebtn.click();
}
public void issueBtn() {
	issuebtn.click();
	WebElement select = issuebtn;
	wLib.select(select, 2);
}
public void describtion(String text) {
	discribebtn.sendKeys(text);
	submitbtn.click();
	
}
public void confirmMsg(String expdata) {
	String actual = confirmMsg.getText();
	if(actual.contains(expdata)) {
		System.out.println("Package has created successfully");
	}
	else {
		System.out.println("Package has not created");
	}
}
 public void issueTicket() {
	 issuetickbtn.click();
	 
 }

public void cancelConfirm(String expdata) {
	String actual = confirmcancel.getText();
	if(actual.contains(expdata)) {
		System.out.println("Issue has been created succesfully");
	}
	else {
		System.out.println("Issue has not been created");
	}
}
public void logout() {
	logoutbtn.click();
}




}



	
	

