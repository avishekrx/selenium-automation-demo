package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utilities.Utility;
import com.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	Utility utility = new Utility();
	
	//Page factory model
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory - OR:
		
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@href='https://api.cogmento.com/register']")
	WebElement signUpButton;
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void login()
	{
		email.sendKeys("");
		password.sendKeys("");
		loginbutton.click();
	}
	
	public void clickOnSignUpButton()
	{
		//signUpButton.click();
		utility.clickButtonWebElement(signUpButton);
		utility.implicitWait(5);
		
	}

}
