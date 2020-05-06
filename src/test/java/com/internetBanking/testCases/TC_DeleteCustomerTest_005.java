package com.internetBanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.internetBanking.pageObjects.DeleteCustomer;
import com.internetBanking.pageObjects.EditCustomer;
import com.internetBanking.pageObjects.LoginPage;

public class TC_DeleteCustomerTest_005 extends BaseClass {

	@Test
	public void deleteCustomer() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		DeleteCustomer dl = new DeleteCustomer(driver);
		lp.setUserName(username);
		log.info("username is provided");
		lp.setPassword(password);
		log.info("password is provided");
		lp.clickSubmit();

		Thread.sleep(3000);
		dl.clickDelCusBtn();

		EditCustomer ec = new EditCustomer(driver);
		ec.cusIdInput(id2);
		log.info("Provided user Id");
		ec.submitBtn();
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert();// close alert
			log.info("Switched to alert: Do you really want to delete Customer?");
			driver.switchTo().alert().accept();
			log.info("Alert accepted: Do you really want to delete Customer?");
			driver.switchTo().alert();
			log.info("Switched to new alert");
			String alertText = driver.switchTo().alert().getText();
			if (alertText.equalsIgnoreCase("Customer does not exist!!")) {
				driver.switchTo().alert().accept();
				log.info("Switch to alert: Non exist accepted");
				log.info("Customer does not exist");
			} else {
				log.info("Switched to alert: Successfully Deleted Customer");
				driver.switchTo().alert().accept();
				log.info("Switch to alert: delete accepted");
			}
		} else {
			Assert.assertTrue(false);
			log.info("test failed");
			Thread.sleep(3000);
		}

		log.info("Validation started");

		boolean result = driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank");
		if (result == true) {
			Assert.assertTrue(true);
			log.info("Test case passed and navigated to Home page");
		} else {
			getScreenShot(driver, "addNewCustomer");
			log.info("TestCase is failed and navigated to delete user page");
			Assert.assertTrue(false);

		}

		lp.clickLogout();
		log.info("Clicked Logout button");

	}
}
