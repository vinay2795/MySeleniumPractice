package com.sample;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DynamicWebtable {
	@Test
	public void dynamicWebtable() {

		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
		driver.get("http://localhost:8888");
          //login
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).click();
		  
		  //navigate to Product Page
		  driver.findElement(By.linkText("Products")).click();
		 
		  String expProductName = "nokia";
		  boolean flag = false;
		  int count =2;
		  
		  //capture all the product Name from dynamic Webtabl
		  List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
           //get row count
		    //System.out.println(lst.size());
		    
		   //display all the 3 column Data
		    for(WebElement wb : lst) {
		    	String productName = wb.getText();
		    	 if(productName.equals(expProductName)) {
		    		// wb.click();
		    
		    		 flag  =true;
		    		 break;
		    	 }
		    	 count++;
		    }
		
             System.out.println(count);
             
             driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+count+"]/td[1]/input")).click();
	}

}
