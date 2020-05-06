package com.internetBanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.internetBanking.pageObjects.AddCustomerPage;
import com.internetBanking.pageObjects.EditCustomer;
import com.internetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		EditCustomer ec = new EditCustomer(driver);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("username is provided");
		lp.setPassword(password);
		log.info("password is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addCus = new AddCustomerPage(driver);
		addCus.clickAddCustomer();

		log.info("Providing customer's details...");

		addCus.custNmae("Nicholas Page");
		addCus.custgender("male");
		addCus.custdob("12", "10", "1968");
		Thread.sleep(5000);
		addCus.custaddress("Nigeria");
		addCus.custcity("TYT");
		addCus.custstate("Araggo");
		addCus.custpinno("1365244");
		addCus.custtelephoneno("2134801219");

		String email = randomString() + "@gmail.com";
		addCus.custemailid(email);

		addCus.custpassword("1258sthgga12");
		addCus.custsubmit();

		Thread.sleep(3000);

		log.info("Validation started");

		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
			log.info("TestCase is passed");
		} else {
			getScreenShot(driver, "addNewCustomer");
			Assert.assertTrue(false);
			log.info("TestCase is failed");
		}

		ec.homeLink();
		log.info("Navigated to home page");

		lp.clickLogout();
		log.info("Clicked Logout button");

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			log.info("Successfully Logged out");
		} else {
			Assert.assertTrue(false);
			log.info("No alert!!! Couldn't log out");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}
	}

}
