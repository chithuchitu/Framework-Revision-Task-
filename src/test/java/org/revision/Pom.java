package org.revision;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.pojo.LoginPojo;

public class Pom extends BaseClass{

	public static void main(String[] args) {

		launchBrowser("chrome");
		launchUrl("https://www.facebook.com/");

		LoginPojo l = new LoginPojo();

		WebElement username = l.getEmailBox();
		passValue(username, "greens@gmail.com");
		WebElement password = l.getPasswordBox();
		passValue(password, "1234");

 
 





	}







}
