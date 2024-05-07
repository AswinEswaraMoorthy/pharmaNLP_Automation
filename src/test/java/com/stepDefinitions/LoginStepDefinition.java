package com.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.dockerjava.api.model.Driver;
import com.pageobject.LoginPage;
import com.utils.Baseclass;
import com.utils.LoadProperties;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;

public class LoginStepDefinition extends Baseclass {

	WebDriver driver;
	WebdriverUtil webdriver;

	@SuppressWarnings("static-access")
	@Before
	public void LaunchBrowser() throws Throwable {
		webdriver = new WebdriverUtil();
		driver = webdriver.launchBrowser(LoadProperties.getProperties("BROWSER"));

	}

	LoginPage lp;

	@Given("User lauch the PharmaNLP application")
	public void user_lauch_the_pharma_nlp_application() throws Throwable {
		driver.get(LoadProperties.getProperties("App_URL"));
	}

	@Then("The logo should occur")
	public void the_logo_should_occur() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.logovalidation();
	}

	@When("User login with Invalid username and password")
	public void user_login_with_invalid_username_and_password() throws IOException {
		lp.enterInvalidUsername();
		lp.enterInvalidPassword();
		lp.clickLoginButton();
		lp.toastervalidation();
		takeScreenshot();
	}

	@When("User login with valid username and password")
	public void user_login_with_valid_username_and_password() throws IOException {
		lp.enterUsername();
		lp.enterPassword();
		lp.clickLoginButton();
		takeScreenshot();

	}

	@Then("User successfully navigate to My Projects page")
	public void user_successfully_navigate_to_my_projects_page() throws InterruptedException {
		lp.isLoggedIn();
		lp.validation();
		takeScreenshot();

	}

}
