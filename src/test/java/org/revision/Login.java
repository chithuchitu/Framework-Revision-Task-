package org.revision;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\KEERTHI\\eclipse-workspace\\Selenium_First_Class\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		 File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\Login.xlsx");
		 FileInputStream fis = new FileInputStream(f);
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sh = workbook.getSheetAt(0);
		  XSSFCell username = sh.getRow(1).getCell(0); 
		  XSSFCell password = sh.getRow(1).getCell(1);
		  
		  
		// Import data for Email.
	         
	         driver.findElement(By.id("email")).sendKeys(username.getStringCellValue()); 	
	         
	         
	      // Import data for Password
	         
	         driver.findElement(By.id("pass")).sendKeys(password.getStringCellValue());
	         driver.findElement(By.name("login")).click();
	         Thread.sleep(2000);
	          
	
	         System.out.println("Read Dta from Excel & Login to Facebook Page Succuessfully!!");
	          driver.close();
	
	
	}
	
	
	

}
     