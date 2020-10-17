package com.sample;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DynamicWebtable2 {
	@Test
	public void dynamicWebtable() {

		
ArrayList<String> lst1 = new ArrayList<String>();
ArrayList<String> lst2 = new ArrayList<String>();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
		driver.get("http://localhost:8888");
          //login
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).click();
		  
		  //navigate to Product Page
		  driver.findElement(By.linkText("Products")).click();

		  //capture all the product Name from dynamic Webtabl
		  List<WebElement> l1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[position()>1]/td[3]/a"));
		  

		    
		   //display all the 3 column Data
		    for(WebElement wb : l1) {
		    	String productName = wb.getText();
		    	   lst1.add(productName.toLowerCase());
		    }
		        
		     Collections.sort(lst1);
		     System.out.println(lst1);
		    
               //click on Sort Link
               driver.findElement(By.linkText("Product Name")).click();
               
				
				  WebDriverWait wait = new WebDriverWait(driver, 20);
				  wait.until(ExpectedConditions.elementToBeClickable(
				  By.xpath("(//img[contains(@src,'arrow_down')])[2]")));
				 
               
             //capture all the product Name from dynamic Webtable
         	  List<WebElement> l2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[position()>1]/td[3]/a"));
         	 //display all the 3 column Data
  		    for(WebElement wb : l2) {
  		    	String productName = wb.getText();
  		    	   lst2.add(productName.toLowerCase());
  		    }
  		    
  		    System.out.println(lst2);
  		    
  		    Assert.assertEquals(lst1, lst2);
  		    
	}

}
