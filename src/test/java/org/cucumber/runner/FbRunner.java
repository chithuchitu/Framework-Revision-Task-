package org.cucumber.runner;

import org.baseclass.BaseClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;



@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\FeatureFile\\fb.feature",glue="org.cucumberRevision.FbStepDefinition.java"
,dryRun=false,stepNotifications = true,monochrome=true

 )
public class FbRunner 	 {
	//public static WebDriver driver= BaseClass.driver;
@BeforeClass
	public static void setUp() {
	
	System.out.println("Browser Launched Successfully");
	

	}
@AfterClass
	 public static void tearDown() {
	System.out.println("close");
		// driver.close();

	}

}
