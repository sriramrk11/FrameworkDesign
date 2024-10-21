package com.mypage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageheader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some Error occurred while creating Element " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.print("Some exception/error occurred while waiting for the element "+ locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
			
		} catch (Exception e) {
			System.out.print("Some exception/error occurred while waiting for the element "+ title);
		}
	}

	@Override
	public String getVersionNumber(By locator) {
		return  getElement(locator).getText();
	}
	
//	public void screenShot(ITestResult result) {
//		// using ITestResult.FAILURE is equals to result.getStatus then it enter into if
//		// condition
//		if (ITestResult.FAILURE == result.getStatus()) {
//			try {
//				// To create reference of TakesScreenshot
//				TakesScreenshot screenshot = (TakesScreenshot) driver;
//				// Call method to capture screenshot
//				File src = screenshot.getScreenshotAs(OutputType.FILE);
//				// Copy files to specific location
//				// result.getName() will return name of test case so that screenshot name will
//				// be same as test case name
//				FileUtils.copyFile(src,
//						new File("D:\\InterviewWorkSpace\\FrameworkDesign\\screenshot\\" + result.getName() + ".png"));
//				System.out.println("Successfully captured a screenshot");
//			} catch (Exception e) {
//				System.out.println("Exception while taking screenshot " + e.getMessage());
//			}
//		}
//	}
}
