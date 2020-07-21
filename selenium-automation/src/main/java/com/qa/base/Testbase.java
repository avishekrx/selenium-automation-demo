package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.Utilities.Utility;

public class Testbase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public Testbase() 
	{
		prop = new Properties();
		
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
	

//	@Test
	public static void initialize()
	{
		String browserurl = prop.getProperty("url");
			
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		 driver = new ChromeDriver();
		
		 driver.get(browserurl);
		 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 
		
	}

}
