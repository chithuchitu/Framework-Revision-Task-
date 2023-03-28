package org.revision;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleLogin {
	public static void main(String[] args) throws IOException, InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\KEERTHI\\eclipse-workspace\\Selenium_First_Class\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	 File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\Login.xlsx");
	 FileInputStream fis = new FileInputStream(f);
	  XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  XSSFSheet sh = workbook.getSheetAt(0);
	  int rowCount = sh.getLastRowNum();
	 int  colCount = sh.getRow(1).getLastCellNum();
	 System.out.println( "  Row Count:"  +rowCount+  "  Column Count"+   colCount);
	 for (int i = 1; i < rowCount; i++) {
		 XSSFRow cellData = sh.getRow(i);
		 String username = cellData.getCell(0).getStringCellValue();
		 String password = cellData.getCell(1).getStringCellValue();
		// Import data for Email.
		 driver.findElement(By.id("email")).clear();
         driver.findElement(By.id("email")).sendKeys(username);
         
      // Import data for Password
         driver.findElement(By.id("pass")).clear();
         
         driver.findElement(By.id("pass")).sendKeys(password);
         System.out.println(i+"."+username+"||"+password);
         driver.findElement(By.name("login")).click();
         Thread.sleep(2000);
          
         
         
         
		
	}
	 
	  	
	  
 
  
 
	  }
	  
	 
	 
	 
}
