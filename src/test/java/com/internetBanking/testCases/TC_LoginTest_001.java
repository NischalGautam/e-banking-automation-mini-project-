package com.internetBanking.testCases;




import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetBanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass 
{
 @Test
 public void loginTest() throws InterruptedException, IOException
 {
	 driver.manage().window().maximize();
	//driver.get(baseUrl);
	log.info("URL is opened");
	
	
	 
	 LoginPage lp = new LoginPage(driver);
	 lp.setUserName(username);
	 log.info("Entered username");
	 
	 lp.setPassword(password);
	 log.info("Entered password");
	 
	 lp.clickSubmit();
	 log.info("Clicked submit button");
	 
	 //Thread.sleep(2000);
	 
	 if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	 {
		 Assert.assertTrue(true);
		 log.info("Login test passed");
	 }else 
	 {
		 getScreenShot(driver,"loginTest");
		 Assert.assertTrue(false);
		 log.info("Login test failed");
	 }
	 
	 lp.clickLogout();
	 log.info("Clicked Logout button");
	 
	 
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			log.info("Login passed");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("No alert");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
 }
	

