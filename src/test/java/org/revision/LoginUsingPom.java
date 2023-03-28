package org.revision;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.pojo.ExcelLoginPojo;

public class LoginUsingPom extends BaseClass {
	 public static void main(String[] args) throws IOException {
		 launchBrowser("chrome");
		 launchUrl("http://adactinhotelapp.com/");
		 maximizeWindow();
		 ExcelLoginPojo l = new ExcelLoginPojo();
//		 l.getUsername().sendKeys("Shahishahii");
//		 l.getPassword().sendKeys("Shahi@123");
 
		 
//		 Read from excel
		 l.getUsername().sendKeys(readExcel("Login", 1, 0));
		 l.getPassword().sendKeys(readExcel("Login", 1, 1));
		 Click(l.getLoginBtn());
		 System.out.println("Read data from excel & login Success to adacitin");
 	 
		 closeBrowser();
		 
		
	}
	
	
	
	
	
	
	
	
	

}
