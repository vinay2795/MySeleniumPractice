package com.learningwebtable;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.app.genericlib.BaseClass;


public class VtigerContacts {
	@Test
	public void dynamicWebtable() throws Exception {

		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
          //login
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).click();
		  
		  //navigate to organization
		  driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		  //click on create button
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		  //create a new organization
		  driver.findElement(By.name("accountname")).sendKeys("testYantra2");
		  //save the text
		  driver.findElement(By.xpath("(//input[contains(@title,'Save')])[1]")).click();
		  
		  Thread.sleep(3000);
		  //click on contacts
		  driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		  //create contacts
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		  //input contact name
		  driver.findElement(By.name("firstname")).sendKeys("vinay1");
		  //click button to select organization name
		  driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		  
		  //window popup handling code
		  Set<String> handler = driver.getWindowHandles();
		  Iterator<String> it = handler.iterator();
		  String parentWindowId=it.next();
		  System.out.println("parent window id:"+parentWindowId);
		  
		  String childWindowId=it.next();
		  System.out.println("child window id:"+childWindowId);
		  
		  driver.switchTo().window(childWindowId);
		  System.out.println("child window pop up title:"+driver.getTitle());
		  
		  //window popup table handling code
		  
		  
		  //driver.close();
		  
		  //switch to parent window
		  driver.switchTo().window(parentWindowId);
		  System.out.println("parent window pop up title:"+driver.getTitle());
	}

}
