package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Utilities.Utility;
import com.qa.base.Testbase;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;

public class LoginPageTest extends Testbase{
	
	LoginPage loginPage;
	SignUpPage signUpPage;
	
	public LoginPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void initializeTest()
	{
		initialize();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void validatePageTitle()
	{
		String pageTitle = loginPage.getPageTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Cogmento CRM","Page title does not match");
	}
	
	@Test(priority = 2)
	public SignUpPage navigateToSignUpPage()
	{
		loginPage.clickOnSignUpButton();
		
		// returns/navigates to a new page
		return signUpPage;
		
	}

	@AfterMethod
	public void close()
	{
		driver.close();
		driver.quit();
	}
}
