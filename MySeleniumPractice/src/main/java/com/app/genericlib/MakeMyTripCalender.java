package com.app.genericlib;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class MakeMyTripCalender {
	public String getCurrentSystemDateAndTime() {
		Date date = new Date();
		  String currentData = date.toString();
		return currentData;
	}
	
	public void handleCalenderwindow(WebDriver driver,String day, String month, String year) {
		int count=1;    
	      while(count<12){
		        try {
		           //click on expected Date
		        	String x = "//div[contains(@aria-label,'"+month+" "+day+" "+year+"')]";
		           driver.findElement(By.xpath(x)).click();
		           break;
		        }catch (Throwable e) {
					System.out.println("handle ");
			        //Click on Next Month
			        driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			        count++;
				}
	      }
	      if(count==12) {
	    	  System.out.println("invalid date");
	      }else {
	    	  System.out.println("valid date");
	      }
	}

}
