package org.revision;

import org.baseclass.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pojo.LoginPojo;

 

public class JunitAssert extends BaseClass {
	static WebDriver driver;
	
	
	
	
	
	@Test
	public void tc3() {
		LoginPojo l = new LoginPojo();
		WebElement username = l.getEmailBox();
		passValue(username, "chithra@gmail.com");
		String id = username.getAttribute("value");
		System.out.println(id);
	  Assert.assertEquals("check email", "chithra@gmail.com", id);
		 
		
	WebElement password = l.getPasswordBox();
		passValue(password, "chithra");
		Assert.assertEquals("check password","chithra" , password.getAttribute("value"));
	}
	@Test
	 public  void tc1() {
		System.out.println("tc1.....");
		 String title = title();
		Assert.assertTrue("check title", title.contains("Face"));
		System.out.println(title);
		String currentUrl = currentUrl();
		Assert.assertTrue("check url",currentUrl.startsWith("https"));
		System.out.println(currentUrl);

	}
	@Test
	public void tc2() {
		Assert.assertTrue("check tc 2",true);
		System.out.println("tc....2");

	}
	public void tc4() {
		 Assert.assertTrue(false);
		 System.out.println("tc...4");
	}

	 
	@Before
	public void bef() {
		System.out.println("Before Test case");
  
	}
	@BeforeClass
	public static void bef1() {
		 launchBrowser("chrome");
		 launchUrl("https://www.facebook.com/");
		 maximizeWindow();

	}
	@After
	public void aft() {
		 System.out.println("after test case .....");
	}
	@AfterClass
	public static  void aft1() {
		closeBrowser();
	 

	}

}
