package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class UserPage extends BaseClass {

	
	@FindBy(name="user_login") 
	WebElement username;
	
	@FindBy(id="email") 
	WebElement emailid;
	
	@FindBy(name="first_name") 
	WebElement firstname;
	
	@FindBy(id="last_name") 
	WebElement lastname;
	
	@FindBy(id="url") 
	WebElement website;
	
	@FindBy(xpath="//input[@id='createusersub']") 
	WebElement addnewuser;
	
	
	
	public UserPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void getintodata(String user,String maild,String fname,String lname,String websi) {
		
		username.sendKeys(user);
		emailid.sendKeys(maild);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		website.sendKeys(websi);
		addnewuser.click();
		
		
		
		
		
		
		
	}
	
}
