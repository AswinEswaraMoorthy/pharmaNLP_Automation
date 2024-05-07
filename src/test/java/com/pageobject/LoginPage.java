package com.pageobject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.Baseclass;
import com.utils.ExcelReader;

public class LoginPage extends Baseclass {

	Baseclass bs = new Baseclass();

	public static ExcelReader Excel = new ExcelReader();
	Object[][] objectArray;

	@SuppressWarnings("static-access")
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='outlined-basic1']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='outlined-basic2']")
	private WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginbtn;

	@FindBy(xpath = "//p[text()='Invalid username or password']")
	private WebElement invalidloginToaster;

	@FindBy(xpath = "(//img[@alt='Logo'])[2]")
	private WebElement logo;

	public void enterInvalidUsername() throws IOException {
		passText(username, "aswin@capestart.com");
	}

	public void enterInvalidPassword() throws IOException {
		passText(password, randomNumberString);
	}

	public void enterUsername() throws IOException {
		clearText(username);
		objectArray = Excel.getTestData();
		String Uname = (String) objectArray[0][0];
		username.sendKeys(Uname);
	}

	public void enterPassword() throws IOException {
		clearText(password);
		objectArray = Excel.getTestData();
		String Pwd = (String) objectArray[0][1];
		password.sendKeys(Pwd);
	}

	public void clickLoginButton() {
		loginbtn.click();
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	public void validation() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(search));
		passText(search, "test");

	}

	public void isLoggedIn() throws InterruptedException {
		explicitwait();
		Assert.assertEquals(constantValues.default_Url, driver.getCurrentUrl());

	}

	public void toastervalidation() throws IOException {
		explicitwait();
		validateToasterMessage(invalidloginToaster, constantValues.invalidUserNameToaster);
	}

	public void logovalidation() {
		explicitwait();
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		Assert.assertNotNull("Image element is not present", logo);
	}
}
