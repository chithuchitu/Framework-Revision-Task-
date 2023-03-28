package org.revision;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitRevision {

	static WebDriver driver;

	@Test
	public   void tc33() {
		System.out.println("tc33....");
	 
		driver.findElement(By.id("email")).sendKeys("chitr@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Chra@4792");
		driver.findElement(By.name("login")).click();
		System.out.println("Tiltle");
		String t2 = driver.getTitle();
		System.out.println(t2);
		 if (t2.contains("Facebook – log in or sign up")) {
			 System.out.println("Invlaid password");
			
		}
		 else {
			System.out.println("Login success");
		}
		 

	}
	
	 
	@Test
	public void tc22() {
		System.out.println("tc22....");

		String c = driver.getCurrentUrl();
		System.out.println(c);
	}
	@Test
	public  void tc11() {
		System.out.println("tc..11...");
	 
		String t = driver.getTitle();
		System.out.println(t);

	}
	@Before
	public void bef1() {
		System.out.println("Test Case Start...");
		Date d1 = new Date();
		System.out.println(d1);


	}
	@AfterClass
	public static void aft1() {
		driver.close();

	}
	@After
	public void aft() {
		System.out.println("Test Case end...");
		Date d = new Date();
		System.out.println(d);


	}
	@BeforeClass

	public static void bef() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();


	}


}
