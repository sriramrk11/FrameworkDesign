package com.mypage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	WebDriverWait wait;

	public Page(WebDriver driver) {
		this(driver, Duration.ofSeconds(15));
	}

	public Page(WebDriver driver, Duration duration) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, duration);
	}

	public abstract String getPageTitle();

	public abstract String getPageheader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract void waitElementPresent(By locator);

	public abstract void waitForPageTitle(String title);
	
	public abstract String getVersionNumber(By locator);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
