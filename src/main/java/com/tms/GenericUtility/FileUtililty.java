package com.tms.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;


public class FileUtililty {
	
	
public String getPropertyData(String Key) throws Throwable {
	
	FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(Key);
	return value;
	
}
	
	
	
}
