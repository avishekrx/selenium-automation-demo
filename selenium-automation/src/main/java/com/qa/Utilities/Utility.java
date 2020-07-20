package com.qa.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.qa.base.Testbase;

public class Utility extends Testbase{
	
	public Utility() {
		
		super();
		
	}
	
	
	public String getWebElementText(WebElement ele)
	{
		
		return ele.getText();
		
	}
	
	
	public void clickButtonWebElement(WebElement ele)
	{
		
		ele.click();
		
	}
	
	
	public void implicitWait(WebElement ele , int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void implicitWait(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

}
