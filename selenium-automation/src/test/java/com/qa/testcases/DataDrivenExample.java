package com.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import com.qa.base.Testbase;

public class DataDrivenExample extends Testbase{
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
    
	public DataDrivenExample()
	{
		super();
	}
	
	
	@BeforeMethod
	public void initializeTest()
	{
		initialize();
		
	}
	
	@Test(priority=1 , enabled = false)
	public void readData() throws IOException
	{

	     // Pass the path of excel sheet to file
	     File srcFile  = new File(System.getProperty("user.dir")+"/src/main/resources/DataSheet.xlsx");
	      
	     // Read data from excel and load the file
	     FileInputStream finput = new FileInputStream(srcFile);
	      
	     // Load the workbook.
	     workbook = new XSSFWorkbook(finput);
	      
	     // Load the sheet in which data is stored.
	     sheet = workbook.getSheetAt(0);
	     
	     int rowcount = sheet.getLastRowNum();
	     System.out.println("rowcount : " + rowcount);
	      
	     for(int i=1; i<rowcount; i++)
	     {
	         // Import data for Email.
	         cell = sheet.getRow(i).getCell(1);
	         cell.setCellType(CellType.STRING);
	         driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
	          
	         // Import data for password.
	         cell = sheet.getRow(i).getCell(2);
	         cell.setCellType(CellType.STRING);
	         driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue());
	                 
	        }
	  } 
	
	 @Test(priority=2, enabled = true)
	 public void writeData() throws IOException, Exception{ 
	 
	 // Import excel sheet.
	 File srcFile =new File(System.getProperty("user.dir")+"/src/main/resources/DataSheet.xlsx");  
	 // Load the file.
	 FileInputStream fis = new FileInputStream(srcFile);
	 // Load he workbook.
	 workbook = new XSSFWorkbook(fis);
	 // Load the sheet in which data is stored.
	 sheet= workbook.getSheetAt(0);
	 
	 for(int i=1; i<=sheet.getLastRowNum(); i++){
	 
	 // Import data for Email.
	 cell = sheet.getRow(i).getCell(1);
	 cell.setCellType(CellType.STRING);
	// driver.findElement(By.id("email")).clear();
	 driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
	 
	 // Import data for password.
	 cell = sheet.getRow(i).getCell(2);
	 cell.setCellType(CellType.STRING);
//	 driver.findElement(By.id("pass")).clear();          
	 driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue());
	 
	 
	 // To click on Login button
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 
	 //To write data in the excel
	 FileOutputStream fos=new FileOutputStream(srcFile);
	 // Message to be written in the excel sheet
	     String message = "Fail";
	     
	     // Create cell where data needs to be written.
	     sheet.getRow(i).createCell(3).setCellValue(message);
	         
	     // finally write content
	     workbook.write(fos);
	 // To click on Account settings dropdown 

	 // close the file
	 fos.close();
	         
	   
	         
	 }
	 }
	
	
	@AfterMethod
	public void close()
	{
		tearDown();          
	}

}
