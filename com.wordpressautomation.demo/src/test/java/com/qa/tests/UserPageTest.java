package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MediaPage;
import com.qa.pages.Toolspage;
import com.qa.pages.UserPage;
import com.qa.util.Utility;

public class UserPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homePage;
	Utility util;
	UserPage userpages;
	
	String sheetName="userdetail";
	
	
	
	
	public UserPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		intialization();
		loginpage = new LoginPage();
		homePage= new HomePage();
		homePage= loginpage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
	    util =new Utility();
		userpages=new UserPage();
	}
	
	@DataProvider
	public Object[][]dataexcel(){
		
		Object data[][]=util.getdata(sheetName);
		return data;
	}
	
	@Test(dataProvider="dataexcel")
	public void enterdata(String uid,String mailinfo,String first,String last,String webs) {
		homePage.clickonuser();
		
	userpages.getintodata(uid, mailinfo, first, last, webs);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

	
	
	

}
