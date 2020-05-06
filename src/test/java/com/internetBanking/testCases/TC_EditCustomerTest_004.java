package com.internetBanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.internetBanking.pageObjects.AddCustomerPage;
import com.internetBanking.pageObjects.EditCustomer;
import com.internetBanking.pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass {

	@Test
	public void editCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("Username provided");
		lp.setPassword(password);
		log.info("Password provided");
		lp.clickSubmit();
		log.info("login successful");

		EditCustomer ec = new EditCustomer(driver);
		log.info("Clicked Edit Customer Link");
		ec.clickEditCusBtn();
		log.info("Provided user Id");
		ec.cusIdInput(id1);
		ec.submitBtn();

		AddCustomerPage ap = new AddCustomerPage(driver);

		ap.clearAddressInfo();
		log.info("Cleared previous entry");
		ap.custaddress("Nepalgunj231, Nepal");
		log.info("Populated text area with new info1");

		ap.clearCityInfo();

		ap.custcity("Kathmandu");
		log.info("Populated text area with new info2");

		ap.clearTextPin();
		log.info("Cleared previous entry");
		ap.custpinno("1246747");
		log.info("Populated text area with new info3");

		ap.clearEmailInfo();
		log.info("Cleared previous entry");
		String email = randomString() + "@gmail.com";
		ap.custemailid(email);

		ap.custsubmit();

		boolean result = driver.getPageSource().contains("Customer details updated Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
			log.info("TestCase is passed");
		} else {
			getScreenShot(driver, "editCustomer");
			Assert.assertTrue(false);
			log.info("TestCase is failed");
		}
		ec.homeLink();
		log.info("Navigated to Home page");

	}

}
