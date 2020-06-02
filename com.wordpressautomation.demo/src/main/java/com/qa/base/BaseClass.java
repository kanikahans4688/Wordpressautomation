package com.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestListener;
import com.qa.util.Utility;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static TestListener eventlistener;
	public  static EventFiringWebDriver e_driver;
	
	public BaseClass() {
	
		try {
			prop=new Properties();
			FileInputStream fis= new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	public static void intialization() {
		
	String browsername=	prop.getProperty("browser");
	
	if(browsername.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\all\\ChromeDriver83\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
	}
	
	
	e_driver= new EventFiringWebDriver(driver);
	
	eventlistener=new TestListener();
	
	e_driver.register(eventlistener);
	
	driver=e_driver;
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Utility.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
		
	}

}



