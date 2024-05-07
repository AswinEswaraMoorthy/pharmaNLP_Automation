package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchDriver {

	public static WebDriver driver;

	@Before
	public void beforeScenario() {

		try {

			if (driver == null) {
				launchBrowser();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void launchBrowser() {

		switch ("chrome") {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\aswin.moorthy\\Automation\\PNLP_BDD\\src\\test\\resources\\drivers");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\aswin.moorthy\\Automation\\PNLP_BDD\\src\\test\\resources\\drivers");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\aswin.moorthy\\Automation\\PNLP_BDD\\src\\test\\resources\\drivers");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Unsupported browser: " );
		}

	}

}
