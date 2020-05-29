package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	
	@FindBy(name="log") 
	WebElement username;
	
	@FindBy(id="user_pass") 
	WebElement password;
	
	@FindBy(name="wp-submit") 
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Powered by WordPress')]") 
	WebElement image;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifytitle() {
		
	return	driver.getTitle();
	}
	
	public boolean verifyimage() {
		
		return image.isDisplayed();
	}
	
	public HomePage validatelogin(String uname,String passw) {
		
		username.sendKeys(uname);
		
		password.sendKeys(passw);
		
		loginbtn.click();
		
		return new HomePage();
		
		
		
		
		
	}
	
}
