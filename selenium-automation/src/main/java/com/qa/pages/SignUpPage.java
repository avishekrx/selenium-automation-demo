package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utilities.Utility;
import com.qa.base.Testbase;

public class SignUpPage extends Testbase{
	
	Utility utility = new Utility();
	//Page Factory - OR:
	@FindBy(xpath="//h2[@class='ui blue header']")
	WebElement register;
	
	public SignUpPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getRegisterText()
	{
		//return register.getText();
		utility.implicitWait(register, 4);
		return utility.getWebElementText(register);
	}

}
