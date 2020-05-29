package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MediaPage;

public class MediaPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homePage;
	//Toolspage toolspage;
	MediaPage mediapage;
	
	public MediaPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		intialization();
		loginpage = new LoginPage();
		homePage=new HomePage();
		homePage= loginpage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));;
		mediapage =new MediaPage();
		//toolspage=new Toolspage();
	}
	

	
	
	@Test(priority=1)
	public void verifytitletoolstest() {
		
		String actual_title=mediapage.verifytitle();
		
		String expected_title="Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress";
		
		Assert.assertEquals(actual_title, expected_title);
	}
	
	@Test(priority=2)
	public void draganddroptest() throws Exception  {
		
		mediapage.draganddrop();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
