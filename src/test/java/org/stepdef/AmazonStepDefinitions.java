package org.stepdef;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.runner.AmazonRunner;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonStepDefinitions {
	 public static WebDriver driver = AmazonRunner.driver;
	 
	 
	 @Given("user Have To Enter The Url and Search The Product")
	 public void user_have_to_enter_the_url_and_search_the_product() {
		 
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.get("https://www.amazon.in/");

	 }

	 @When("user Choose The Priduct From Webpage and Compare The Title")
	 public void user_choose_the_priduct_from_webpage_and_compare_the_title() throws IOException, InterruptedException {
		 WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

			Select DropdownList = new Select(dropdown);

			List<WebElement> allSelectedOptions = DropdownList.getOptions();

			ListIterator<WebElement> listIterator1 = allSelectedOptions.listIterator();
			String Expected = "Music";

			while (listIterator1.hasNext()) {

			WebElement next = listIterator1.next();

			String IntheList = next.getText();

			if (Expected.equalsIgnoreCase(Expected)) {

			DropdownList.selectByVisibleText(Expected);

			System.out.println("Expected Text in Submenu Bar:" + Expected);

			System.out.println("Actual Text in Submenu Bar:" + next.getText());

			break;
			}
			}

			String SearchKeyword = "cd";

			WebElement Searchword = driver.findElement(By.id("twotabsearchtextbox"));

			Searchword.sendKeys(SearchKeyword);

			Thread.sleep(3000);

			List<WebElement> Searchsuggestions = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));

			for (int i = 1; i <= Searchsuggestions.size(); i++) {

			WebElement EachSearchsuggestions = driver
			.findElement(By.xpath("(//div[@class='s-suggestion-container']/child::div)["+ i + "]"));

			String suggestionWord = EachSearchsuggestions.getText();

			if (suggestionWord.equalsIgnoreCase(SearchKeyword)) {

			System.out.println("Expected Text in Search Bar: " + EachSearchsuggestions.getText());
			System.out.println("Actual Text in Search Bar: " + SearchKeyword);

			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			break;
			}

			}

			WebElement GetTitle1 = driver.findElement(
			By.xpath("(//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div/descendant::h2)[1]"));

			String GetT1 = GetTitle1.getText();

			System.out.println("Produc Name in Product List: " + GetT1);

			driver.findElement(
			By.xpath("(//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div/descendant::h2/a)[1]")).click();

			String AmazonwindowHandle = driver.getWindowHandle();

			Set<String> handle = driver.getWindowHandles();

			for (String Each : handle) {

			if (Each != AmazonwindowHandle) {
			driver.switchTo().window(Each);
			}

			}

			WebElement GetElements = driver.findElement(By.xpath("//div[@id='titleSection']/h1"));

			String GetT2 = GetElements.getText();

			System.out.println("Produc Name in unique page: " + GetT2);

			if (GetT1.equalsIgnoreCase(GetT2)) {

			}

			if (GetT2.equalsIgnoreCase(GetT1)) {

			driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			}

			//
			// //Iterator<String> iterator2 = handle.iterator();
			//
			// while (iterator2.hasNext()) {
			// String handleID = (String) iterator2.next();
			//
			// if (!AmazonwindowHandle.equalsIgnoreCase(handleID)) {

			TakesScreenshot s = (TakesScreenshot) driver;

			File screenshotAs = s.getScreenshotAs(OutputType.FILE);

			File filename = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Screenshot\\Added_to_Cart.png");
			FileUtils.copyFile(screenshotAs, filename);

			driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]")).click();

			List<WebElement> TitleName = driver
			.findElements(By.xpath("//li[@class='a-spacing-mini']//descendant::a[1]/span/span"));

			for (WebElement j2 : TitleName) {

			String GetT3 = j2.getText();

			if (GetT3.equalsIgnoreCase(GetT2)) {

			System.out.println("Product Name in Cart Page: " + GetT3);

			TakesScreenshot scrShot1 = ((TakesScreenshot) driver);

			File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);

			File DestFile1 = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Screenshot\\Go_TO_Cart.png");

			FileUtils.copyFile(SrcFile1, DestFile1);
			driver.close();
			break;
			}

		 
	 }
	 }


}




