package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MediaPage;
import com.qa.pages.Toolspage;

public class HomePageTestValidate extends BaseClass {
	LoginPage loginpage;
	HomePage homePage;
	MediaPage mediaPage;
	Toolspage toolspage;
	
	
	public HomePageTestValidate() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		intialization();
		loginpage = new LoginPage();
		homePage= new HomePage();
		homePage= loginpage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validatetitiletest() {
		
		String title= homePage.verifytitle();
		
		String expected_title="Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress";
		
		Assert.assertEquals(title,expected_title );	
	}
	
	
	@Test(priority=2)
  public void validateadminlabel() {
		
		homePage.validatehomepage();
	}
	
	
	@Test(priority=3)
	
	public void mediatest() {
		
		
		homePage.clickonmedia();
	}
	
	
@Test(priority=4)
	
	public void toolstest() {
		
		
		homePage.clickontools();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
