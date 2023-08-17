package com.Practice.java;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
@Test
	public void test1() {
		System.out.println("Print 1");
		System.out.println("Print 2");
		System.out.println("Print 3");
		
		Assert.assertEquals("a","b");
		System.out.println("Print 4");
		System.out.println("Print 5");
	}
@Test
    public void test2() {
	System.out.println("Print 1");
	System.out.println("Print 2");
	System.out.println("Print 3");
	int a=19;
	Assert.assertNotNull(a);
	System.out.println("Print 4");
	System.out.println("Print 5");
}
	
	
	
	
	
	
}
