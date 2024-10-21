package com.mypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	private By header = By.xpath("//div[@id='coderStats']/div/div/div[contains(normalize-space(.), \"Coder Stats\")]");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getPageheader(header);
	}
	

}
