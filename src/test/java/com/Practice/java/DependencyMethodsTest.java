package com.Practice.java;

import org.testng.annotations.Test;

public class DependencyMethodsTest {
    @Test
	public void test1() {
		System.out.println("Test 1 passed");
	}
    @Test(dependsOnMethods = "test1")
	public void test2() {
		System.out.println("Test 2 passed");
	}
    @Test
	public void test3() {
		System.out.println("Test 3 passed");
	}
	
	
	
	
	
}
