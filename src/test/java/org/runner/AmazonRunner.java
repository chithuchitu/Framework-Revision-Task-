package org.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\org\\featurefile\\Amazon.feature",glue="org.stepdef.AmazonStepDefinitions.java",monochrome=true,
  dryRun=true)
public class AmazonRunner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 
		 

	}
	@AfterClass
	public static void tearDown() {
		 driver.quit();

	}

}
