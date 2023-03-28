package org.revision;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GreensScrlIUp extends BaseClass {

	public static void main(String[] args) throws InterruptedException, AWTException {


		launchBrowser("chrome");
		launchUrl("http://www.greenstechnologys.com/");
		maximizeWindow();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.xpath("//a[text()=' Privacy Policy']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement scrollDown = driver.findElement(By.xpath("//h2[text()='Greens Technologys Overall Reviews']"));

		js.executeScript("arguments[0].scrollIntoView(true)",scrollDown);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='HOME']")).click();
		WebElement scrollUp = driver.findElement(By.xpath("//h1[text()='No 1 Software Training Institutes in Chennai with Placements']"));
		js.executeScript("arguments[0].scrollIntoView(false)",scrollUp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Certifications']")).click();
		WebElement course = driver.findElement(By.xpath("(//a[text()='Course Content'])[29]"));
		js.executeScript("arguments[0].scrollIntoView(true)",course);

		Thread.sleep(2000);
		Actions a = new Actions(driver);
		Robot r = new Robot();
		a.contextClick(course).click().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement title = driver.findElement(By.xpath("//h2[text()='Selenium Training in Chennai']"));
		String text = title.getText();
		System.out.println(text);


	}

}
