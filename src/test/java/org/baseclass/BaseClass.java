package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.revision.WriteExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver launchBrowser(String browsername) {
		
		if (browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String title() {
		String t = driver.getTitle();
		return t;
	}

	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void passValue(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void Click(WebElement element) {
		element.click();

	}

//	===========Take screenshot======

	public static void screenshot(String fileName) throws IOException {
		// (child refname = (child) parent ref;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Screenshot\\" + fileName);
		FileUtils.copyFile(src, dest);

	}

//	===Actions======
	static Actions a;

	public static void mouseHover(WebElement element, WebDriver driver) {
		a = new Actions(driver);
		a.click(element);

	}

	// ==== ACTIONS =======//
	// Actions a = new Actions(driver);

	// Actions ---- Drag and Drop
	public void dragAndDrop(WebElement source, WebElement destination) {
		// a= new Actions(driver);
		a.dragAndDrop(source, destination).perform();
		;
	}

	// Actions =--moveToElement////
	public static void moveToElement(WebElement element, String options) {
		if (options.equalsIgnoreCase("click")) {
			a.click(element);
		} else if (options.equalsIgnoreCase("move")) {
			a.moveToElement(element).perform();

		} else if (options.equalsIgnoreCase("right")) {
			a.contextClick(element).perform();

		} else if (options.equalsIgnoreCase("double")) {
			a.doubleClick(element).perform();

		} else if (options.equalsIgnoreCase("hold")) {
			a.clickAndHold(element);

		}
	}

	public static void copy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

	}

//	        =========Js Executor======
	static JavascriptExecutor js;

	public static void passValueJS(WebElement element, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

//                 ====Alert======
	static Alert al;

	public static void acceptAlert() {
		al = driver.switchTo().alert();
		al.accept();

	}

	public static void dismissAlert() {
		al = driver.switchTo().alert();
		al.dismiss();
	}

	public static void switchToframe(int index, String id, WebElement element) {
		driver.switchTo().frame(index);
	}

	// Use Drop Doon
	public static Select useDropDown(WebElement element) {

		Select s = new Select(element);
		return s;
	}

	// Select By Value
	public static void selectByValue(WebElement element, String value) {
		useDropDown(element).selectByValue(value);
	}

	// Select By Index
	public static void selectByIndex(WebElement element, int indexValue) {
		useDropDown(element).selectByIndex(indexValue);
	}

	// Select by VisibleText
	public void selectByVisibleText(WebElement element, String visibleText) {
		useDropDown(element).selectByVisibleText(visibleText);
	}

	// JavaScriptExecutor - Scroll up and Down
	public static void scrollUpDown(WebElement element, String scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scroll, element);

	}
	// Navigator

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	// Radio Button
	public static void clickRadioButton(WebElement element) {
		element.click();
	}

//	    ===REad Excel======
	public static String readExcel(String sheetName, int row, int cell) throws IOException {
		// File path
		File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\Login.xlsx");
		// Read File
		FileInputStream fis = new FileInputStream(f);
		// Read Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Workbook(.xlsx)-->Sheet--> rows--.cell-->data
		// get sheet from workbook
		XSSFSheet sh = workbook.getSheet(sheetName);
		// Get row from sheet
		XSSFRow r = sh.getRow(row);
		// Get Cel from row
		XSSFCell c = r.getCell(cell);
		// Get cell type
		// if celltype =1 -->String value
		// if celltype=0 --> Numeric or date cell
		int cellType = c.getCellType();

		String value;
		if (cellType == 1) {
			value = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd--MMM-yyyy");
			value = sdf.format(dd);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			// child ref =(child) parent ref;
			value = String.valueOf(1);

		}
		return value;

	}

	public static void writeExcel(String sheetName, int row, int cell, String value) throws IOException {
		// File Path
		File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\text.xlsx");

//Create Workbook
		// workbook-- sheet -->> row-->cell--> data
		Workbook workbook = new XSSFWorkbook();
//	   create sheet
		Sheet sh = workbook.createSheet(sheetName);
//	   Create row
		Row r = sh.createRow(row);

//	   Create cell
		Cell c = r.createCell(cell);
		// Set cell data
		c.setCellValue(value);
//write to excel file
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		System.out.println("write...");

	}

//  Create new cell in existing workbook
//    create cell
	public static void creteCell(String sheetName, int row, int cell, String Value) throws IOException {
		// file path
		File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\test.xlsx");
		// Read file
		FileInputStream fis = new FileInputStream(f);
		// Exisiting workbook-->--exisiting sheet --> new cell-->data
//	    read workbook
		Workbook workbook = new XSSFWorkbook(fis);
//	    Get sheet
		Sheet sh = workbook.getSheet(sheetName);
//	    get row
		Row r = sh.createRow(row);
//	    create cell
		Cell c = r.createCell(cell);
//	    set cell data
		c.setCellValue(Value);
//	    write file
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		System.out.println("write...");

	}

	public static void updateCell(String sheetName, int row, int cell, String newValue, String oldValue)
			throws IOException {
//	file path
		File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\test.xlsx");
//	  read file 
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook();
		// existing workobbok--> existing sheet---> exsiting row--->>exisiting
		// cell--->data
		Sheet sh = workbook.getSheet(sheetName);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		String existingValue = c.getStringCellValue();
		if (existingValue.equals(oldValue)) {

			// set cell data
			c.setCellValue(newValue);

		}
		// write file
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);

	}

}
