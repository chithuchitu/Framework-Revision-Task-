package org.cucumberRevision;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.baseclass.BaseClass;
import org.cucumber.runner.FbRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class FbStepDefinition extends BaseClass {
	
	

	
	@Given("launch The Browser and Enter The Url")
	public void launch_the_browser_and_enter_the_url() {
		launchBrowser("chrome");
		launchUrl("www.facebook.com");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	}
	
	


@When("user Enter The  Invalid Username and Password")
public void user_enter_the_invalid_username_and_password() {
	WebElement mailId= driver.findElement(By.id("email"));
	mailId.sendKeys("chithra");
	WebElement password= driver.findElement(By.id("pass"));
	password.sendKeys("chithra@1233");
	
}

@Then("user Click The Login Button")
public void user_click_the_login_button() {
	 driver.findElement(By.name("login")).click();
	 System.out.println("Incorect Password!");
}

@Then("user Take ScrrenShot for Wrong Password Page")
public void user_take_scrren_shot_for_wrong_password_page() throws IOException {
	TakesScreenshot scrShot1 = ((TakesScreenshot) driver);

	File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);

	File DestFile1 = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Screenshot\\cucuwrongpassword.png");
	FileUtils.copyFile(SrcFile1, DestFile1);
	System.out.println("Wrong Password Page Screenshot Taken");
	
}

@Then("user Go Back To Home Page")
public void user_go_back_to_home_page() {
	 driver.navigate().back();

}

@Then("user Click the Create New Accont Button With Invalid Data")
public void user_click_the_create_new_accont_button_with_invalid_data() {
	WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
	 createAccount.click();
	  WebElement firstName = driver.findElement(By.name("firstname"));
	  firstName.sendKeys("chithra");
	  WebElement lastName = driver.findElement(By.name("lastname"));
	  lastName.sendKeys("pavai");
	  driver.findElement(By.name("reg_email__")).sendKeys("chit@gmail.com");
	  driver.findElement(By.name("reg_passwd__")).sendKeys("56666");
	  WebElement day = driver.findElement(By.name("birthday_day"));
	  Select dropdown1 = new Select(day);
	  dropdown1.selectByValue("8");
	  WebElement month = driver.findElement(By.name("birthday_month"));
	  Select dropdown2 = new Select(month);
	  dropdown2.selectByIndex(2);
	  WebElement year = driver.findElement(By.id("year"));
	  Select dropdown3 = new Select(year);
	  dropdown3.selectByVisibleText("2022");
	  WebElement radio1 = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
	  radio1.click();
	   driver.findElement(By.name("websubmit")).click();
	   System.out.println("New account Created");

}

@Then("user Take Screenshot For Error Page")
public void user_take_screenshot_for_error_page() throws IOException {
	  TakesScreenshot scrShot1 = ((TakesScreenshot) driver);

		File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);

		File DestFile1 = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Screenshot\\fbregisterpage.png");
		FileUtils.copyFile(SrcFile1, DestFile1);
		System.out.println("Take Screenshot for Registeration Error Page");
	
}


}
