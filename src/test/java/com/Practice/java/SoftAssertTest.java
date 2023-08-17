package com.Practice.java;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	
	@Test
	public void testcase1() {
		System.out.println("Print 1");
		System.out.println("Print 2");
		System.out.println("Print 3");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("a","b");
		
		System.out.println("Print 4");
		System.out.println("Print 5");
		sa.assertAll();
	}
@Test
    public void testcase2(){
	System.out.println("Print 1");
	System.out.println("Print 2");
	System.out.println("Print 3");
	SoftAssert sa=new SoftAssert();
	int a=19;
	sa.assertNull(a);
	System.out.println("Print 4");
	System.out.println("Print 5");
	sa.assertAll();
}
}
