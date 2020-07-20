package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Utilities.Utility;
import com.qa.base.Testbase;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;

public class SignUpPageTest extends Testbase{
	
	SignUpPage signUpPage;
	LoginPage loginPage;
	
	public SignUpPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void initializeTest()
	{
		initialize();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
		loginPage.clickOnSignUpButton();
	
		
	}
	
	@Test
	public void verifyRegisterPage()
	{
	//	String expectedValue = signUpPage.getRegisterText();
		String expectedValue = signUpPage.getRegisterText();
		String actualValue = "Register";
		Assert.assertEquals(expectedValue, actualValue,"Both values do not match!");
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
		driver.quit();
	}

}
