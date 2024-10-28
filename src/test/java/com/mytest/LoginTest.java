package com.mytest;

import com.mypage.HomePage;
import com.mypage.LoginPage;
import com.mytest.utils.TestUtils;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(com.mytest.MyTestListeners.class)

public class LoginTest extends BaseTest {
	
	Logger log;
//	SoftAssert softAsserts;
	
	@Test(priority = 1,enabled = false)
	public void verifyLoginTitleTest() {
		log = LogManager.getLogger(TestLogger.class);
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		Assert.assertEquals(title, "UM Health | CodingAi™");
		log.info("Login Title verified");
	}

	@Test(priority = 2,enabled = false)
	public void verifyLoginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
//		softAsserts.assertEquals(header, "Copyright © 2024, Claritrics Inc.");
		Assert.assertEquals(header, "Copyright © 2024, Claritrics Inc.");
	}

	
	@Test(priority = 3,enabled = true,invocationCount = 3)
	@Parameters(value = {"username", "password"})
	
	
	public void verifyVersion() {
		String version = page.getInstance(LoginPage.class).getVersion();
		System.out.println(version);
		Assert.assertEquals(version, "UAT V1.0 r.5782    07/11/2024");
		LoginTest test = new LoginTest();
		test.doLogin(version, version);
	}
	
//	@Test(priority = 4,enabled = true)
//	public void invalidLogin(String username,String password) {
//		System.out.println("test");
//		invalidLogin(username, password);
//		Alert alert = driver.switchTo().alert();
//		String  alertMessage =driver.switchTo().alert().getText();
//		System.out.println(alertMessage);
//		Assert.assertEquals(alertMessage, "INVALID_USERNAME");
//	}
	
//	@DataProvider(name = "invalidLoginFunctionality")
//	public Iterator<Object[][]> dataProvider() {
//		
//		ArrayList<Object[][]> testData= TestUtils.getDataFromUtils();
////		Object[][] obj = {{"demo","Demo@123"}};
////		, {"sriram","Demo@12"},{"Sriramrk","Demo@123#"}
//		return testData.iterator();
//	}
//
	
	@Test(priority = 5,enabled = true)
	
	public void doLogin(String username,String password) {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(username, password);
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "CODER STATS");
	}

}
