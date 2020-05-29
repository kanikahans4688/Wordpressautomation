package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginTestValidate extends BaseClass {
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginTestValidate() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		intialization();
		loginpage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void validatetitiletest() {
		
		String title=loginpage.verifytitle();
		
		String expected_title="Log In ‹ Wordpress Demo Site at Demo.Center — WordPress";
		
		Assert.assertEquals(title,expected_title );	
	}
	@Test(priority=2)
	
	public void validateimage() {
		
		boolean flag=loginpage.verifyimage();
		
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	
	public void verifylogin() {
		
	
	homePage= loginpage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
