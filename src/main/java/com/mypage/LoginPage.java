package com.mypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

//	Page Locators
	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.xpath("//button[@class=\"btn burgundy pull-right submitLogin\"]");
	private By header = By.xpath("//div[contains(normalize-space(.),'Copyright © 2024, Claritrics Inc.')]");
	private By version = By.xpath("//div[@class=\"footer-inner\"]/i");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Public getter
	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}

	public String getLoginPageHeader() {
		return getPageheader(header);
	}

	public String getVersion() {
		return getVersionNumber(version);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */

	public HomePage doLogin(String username, String password) {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();

		return getInstance(HomePage.class);
	}

}
