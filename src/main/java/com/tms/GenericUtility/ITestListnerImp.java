package com.tms.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListnerImp implements ITestListener{
	ExtentReports report;
	ExtentTest test;
@Override
	public void onTestStart(ITestResult result) {
	//Execution starts from here
		String MethodName=result.getMethod().getMethodName();
		 test = report.createTest(MethodName);
		Reporter.log(MethodName+"-----> Test Script execution started");
		
		
	}

@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"---passed");
		Reporter.log(MethodName+"-----> Test Script Passed");
		
	}

@Override
	public void onTestFailure(ITestResult result) {
		
		String FScript=result.getMethod().getMethodName();
		String FailedScript=FScript+new JavaUtility().getSystemDateInFormat();
       EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
     File source  =edriver.getScreenshotAs(OutputType.FILE);
     File destiny=new File("./Screenshots/FailedTestScripts.png");
     try {
    	 FileUtils.copyFile(source, destiny);
     }
     catch (IOException e){
    	 e.printStackTrace();
    	 
     }
     test.log(Status.FAIL,FScript+"--->Failed Script");
     test.log(Status.FAIL,result.getThrowable());
     test.addScreenCaptureFromPath(FailedScript);
     Reporter.log(FScript+"-----> Test Script Failed");
     
       
	}
@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		 test.log(Status.SKIP,MethodName+"--->Skipped Script");
	     test.log(Status.SKIP,result.getThrowable());
	     Reporter.log(MethodName+"-----> Test Script Skipped");
	     
		
		
	}

@Override
	public void onStart(ITestContext context) {
	ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
	htmlReport.config().setDocumentTitle("SDET-50");
	htmlReport.config().setTheme(Theme.STANDARD);
	htmlReport.config().setReportName("T-M-S");
    report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("OS","Windows");
	report.setSystemInfo("Base-Browser","Chrome");
	report.setSystemInfo("Base-url","http:localhost:8888/");
	report.setSystemInfo("Reporter-name","Elango");
	
	}

@Override
	public void onFinish(ITestContext context) {
		// consolidate the report
		report.flush();
	}
	
	
	
	
	
	
	

}
