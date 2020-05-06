package com.internetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {

	WebDriver driver;

	public DeleteCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "Delete Customer")
	@CacheLookup
	WebElement delCusBtn;

	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement idInput;

	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement submitBtn;

	

	public void clickDelCusBtn() {
		delCusBtn.click();
	}

	public void cusIdInput(String id) {
		idInput.sendKeys(id);
	}

	public void submitBtn() {
		submitBtn.click();
	}

}
