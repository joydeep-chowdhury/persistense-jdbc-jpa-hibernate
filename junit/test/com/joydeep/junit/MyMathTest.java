package com.joydeep.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class MyMathTest {
	MyMath myMath=new MyMath();
	
	@Before
	public void beforeTest()
	{
		System.out.println("Before running any test");
	}
	
	@Test
	public void sum_with3nums() {
	   assertEquals(10, myMath.sum(new int[]{2,3,5}));
	}

	@After
	public void afterTest()
	{
		System.out.println("After running any test");
	}
	
	@Test
	public void sum_with1num() {
	   assertEquals(2, myMath.sum(new int[]{2}));
	}
	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("Before executing any test cases");
	}
	@AfterClass
	public static void afterClass()
	{
		System.out.println("After executing all test cases");
	}
}
