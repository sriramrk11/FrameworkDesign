package com.mytest;

import java.io.File;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.mypage.BasePage;
import com.mypage.Page;


public class BaseTest {

	WebDriver driver;
	public Page page;
	org.apache.logging.log4j.Logger log;

	@BeforeMethod
	@Parameters(value = { "browser", "Url" })

	public void setUpDriver(String browser, String Url) {
		log = LogManager.getLogger(TestLogger.class);
		log.info(browser + " - Driver installized ");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Brower is defined in XML file");
		}
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Login page displayed");
		page = new BasePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Driver Quit");
	}

}
