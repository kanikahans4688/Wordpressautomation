package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class MediaPage extends BaseClass {
	
	@FindBy(xpath="//div[contains(text(),'Media')]")
	WebElement clickmedia;
	
	@FindBy(xpath="//a[@class='page-title-action aria-button-if-js']")
	WebElement addnew;

	@FindBy(id="__wp-uploader-id-1")
	WebElement select;
	
	
	public MediaPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifytitle() {
		
		return driver.getTitle();
	}
	
	public void draganddrop() throws Exception{
		
		clickmedia.click();
		
		addnew.click();
		
		
		
		return;
	}
	
		
		
		
		
		
	}
	

