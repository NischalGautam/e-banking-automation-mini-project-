package com.internetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {


	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement addNewCusBtn;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement cusName;
	
	@FindBy(how = How.XPATH, using = "//tr[5]//td[2]//input[2]")
	@CacheLookup
	WebElement rdGenderBtn;
	
	@FindBy(how = How.ID, using = "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelNum;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPwd;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddCustomer() 
	{
		addNewCusBtn.click();
	}
	
	public void custNmae(String cname)
	{
		cusName.sendKeys(cname);
	}
	
	public void custgender(String cgender) {
		rdGenderBtn.click();
	}

	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtCity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtState.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtPin.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
	txtTelNum.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtEmail.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtPwd.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
