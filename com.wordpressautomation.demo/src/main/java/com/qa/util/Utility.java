package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.BaseClass;

public class Utility extends BaseClass {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITLY_WAIT=10;
	
	public static String TESTDATA_PATH="C:\\Users\\all\\git\\Wordpressautomation\\com.wordpressautomation.demo\\src\\main\\java\\com\\qa\\testdata\\sheet.xlsx";

	static Workbook book;
	static Sheet sheet;
	
	public static Object[][]getdata(String sheetName){
		FileInputStream file ;
		try {
			file=new FileInputStream(TESTDATA_PATH);
			book= WorkbookFactory.create(file);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		 
		
		sheet=book.getSheet(sheetName);
		
		Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				
			}
		}
		return data;
	}	
 public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");

	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

 }
}
