package com.stepDefinitions;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.utils.Baseclass;
import com.utils.LoadProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;


public class WebdriverUtil extends Baseclass {

	WebDriver driver;

	public WebDriver launchBrowser(String browser) throws Throwable {

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

		return driver;

	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed() && driver != null) {
			System.out.println("Screenshot taken method IN.");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
	       // Allure.addAttachment("Failed Screenshot", AttachmentType.PNG, screenshot);

			System.out.println("Screenshot taken and attached.");

		}

	}
}
