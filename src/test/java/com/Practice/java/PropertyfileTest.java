package com.Practice.java;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PropertyfileTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream(".//src/test/resources/TmsCommondata.properties");
Properties p=new Properties();
p.load(fis);
String url = p.getProperty("url");
String browser = p.getProperty("browser");
String un = p.getProperty("username");
String pw = p.getProperty("password");
System.out.println(url);
System.out.println(browser);
System.out.println(un);
System.out.println(pw);












	}

}
