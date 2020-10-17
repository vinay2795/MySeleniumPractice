package com.app.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.app.genericlib.MakeMyTripCalender;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe" );
	}
	public static WebDriver driver;
	

	public static void openBrowser(String sBrowser)
		{
			if(sBrowser.equals("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(sBrowser.equals("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(sBrowser.equals("ie"))
			{
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:8888/");
	
	        
	}
	

}
