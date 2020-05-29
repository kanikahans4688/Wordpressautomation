package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePage extends BaseClass {

	
	@FindBy(xpath="//a[contains(text(),'Hi,')]") 
	WebElement adminlabel;
	
	@FindBy(xpath="//div[contains(text(),'Media')]") 
	WebElement medialabel;
	
	@FindBy(xpath="//div[contains(text(),'Tools')]") 
	WebElement toollabels;
	
	@FindBy(xpath="//div[contains(text(),'Users')]") 
	WebElement user;
	
	@FindBy(xpath="//a[@class='page-title-action']")
	WebElement addnew;
	
	
	
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifytitle() {
		
	return	driver.getTitle();
	}
	
	public void validatehomepage() {
		
		adminlabel.click();
	}
	
	public MediaPage clickonmedia() {
		
		medialabel.click();
		
		return new MediaPage();
	}
	
		
		public Toolspage clickontools() {
			
			toollabels.click();
			return new  Toolspage();
			
			
			
			}
		
		public void clickonuser() {
			
			//Actions actions=new Actions(driver);
			
			//actions.moveToElement(user).build().perform();
			
			//addnew.click();
			
			user.click();
			addnew.click();
				
		}
		
		
		
		
		
		
	
	
		
		
		
		
		
	}
	


