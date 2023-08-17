package com.Practice.java;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgTest {
    @BeforeSuite
	public void connectDB() {
		System.out.println("Connect to DB");
	}
    @AfterSuite
    public void closeDB() {
    	System.out.println("Close the DB");
    }
    @BeforeClass
    public void launchBrow() {
    	System.out.println("Launch the Browser");
    	
    }
    @AfterClass
    public void closeBrow() {
    	System.out.println("Close the Browser");
    }
    @BeforeMethod
    public void loginApp() {
    	System.out.println("Login to app");
    }
    @AfterMethod
    public void logoutApp() {
    	System.out.println("Logout the app");
    }
    @Test
    public void pass() {
    	System.out.println("Test Script passed");
    }
    @Test
    public void fail() {
    	System.out.println("Test Script Failed");
    }
    @Test
    public void skip() {
    	System.out.println("Test Script skipped");
    }
    
    
}
    
