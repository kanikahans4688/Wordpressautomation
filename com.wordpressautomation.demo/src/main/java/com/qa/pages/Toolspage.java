package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Toolspage extends BaseClass {

	@FindBy(xpath="//div[contains(text(),'Tools')]")
     WebElement clicktools ;
	
	@FindBy(linkText="Categories and Tags Converter")
	WebElement next;
	
	public Toolspage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle() {
		
		return driver.getTitle();
		
	}
	
		
		
		

		public ContactsPage validatetoolsmove1() {
			
			clicktools.click();
			next.click();
			return new ContactsPage();
		}


		
		
	}
	

