package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass {
//	Non parameterized Constructor
	 public LoginPojo() {
		 PageFactory.initElements(driver, this);
		 // this represents current class properties
		 
		 
	}
	
	
//	WebElement emailbox = driver.findElement(By.id("email"));
	
	@CacheLookup
	@FindBy(id="email")
	private WebElement emailBox;
	
	@CacheLookup
	@FindBy(xpath="//input[@type='password']")
	 private WebElement passwordBox;
	@CacheLookup
	@FindBy(id="u_0_9_xb")
	
	 private WebElement loginButton;
	@CacheLookup
	@FindBys({//acts like AND operator
		@FindBy(xpath="//button[@name='login']"),
		@FindBy(xpath="//button[@type='submit']")
		 
		
		
})
	private WebElement loginFindBys;
	
	@CacheLookup
	@FindAll({// Acts like OR operator
		@FindBy(xpath="//button[@name='login']"),
		@FindBy(xpath="//button[@type='submit']"),
		@FindBy(xpath=" //button[text()='Log in']"),
		@FindBy(id="u_0_5_UY")
		
	})
	private WebElement loginFindAll;

	public WebElement getEmailBox() {
		return emailBox;
	}

	public WebElement getPasswordBox() {
		return passwordBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginFindBys() {
		return loginFindBys;
	}

	public WebElement getLoginFindAll() {
		return loginFindAll;
	}
	
		
		
	 
	
	
	

	
	
	
	
	
 

}
