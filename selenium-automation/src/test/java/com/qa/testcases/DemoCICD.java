package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;

public class DemoCICD extends Testbase{
	
	@BeforeMethod
	public void initializeTest()
	{
		initialize();
		
	}
	
	@Test()
	void facebook_test() throws InterruptedException
	{
		System.out.println("Facebook test");
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Facebook – log in or sign up", driver.getTitle());
		//driver.wait(3000);
	
	}
	
	@Test()
	void google_test() throws InterruptedException
	{
		System.out.println("Google test");
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		//driver.wait(3000);
	}
	
	@Test()
	void gearbest_test() throws InterruptedException
	{
		System.out.println("Gearbest test");
		driver.get("https://www.gearbest.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Gearbest: Affordable Quality, Fun Shopping", driver.getTitle());

	}
	
	@AfterMethod
	public void end()
	{
		tearDown();
	}

}
