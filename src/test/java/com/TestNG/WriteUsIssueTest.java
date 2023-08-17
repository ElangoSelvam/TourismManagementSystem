package com.TestNG;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.ObjectRepository.UserHomePage;

public class WriteUsIssueTest extends BaseClass {
@Test(groups = {"Smoke","Regression"})
	public void writeUs() {
		UserHomePage uhp=new UserHomePage(driver);
		uhp.writeUs();
		uhp.issueBtn();
		uhp.describtion("I have a booking issue");
		uhp.confirmMsg("Confirmation");
		uhp.issueTicket();
		uhp.cancelConfirm("I have a booking issue");
	}
	
	
	
	
}
