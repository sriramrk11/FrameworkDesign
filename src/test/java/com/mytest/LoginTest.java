package com.mytest;

import com.mypage.HomePage;
import com.mypage.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(com.mytest.MyTestListeners.class)

public class LoginTest extends BaseTest {
	
	Logger log;
//	SoftAssert softAsserts;
	
	@Test(priority = 1,enabled = true)
	public void verifyLoginTitleTest() {
		log = LogManager.getLogger(TestLogger.class);
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		Assert.assertEquals(title, "UM Health | CodingAi™");
		log.info("Login Title verified");
	}

	@Test(priority = 2,enabled = true)
	public void verifyLoginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
//		softAsserts.assertEquals(header, "Copyright © 2024, Claritrics Inc.");
		Assert.assertEquals(header, "Copyright © 2024, Claritrics Inc.");
	}

	
	@Test(priority = 3,enabled = true)
	public void verifyVersion() {
		String version = page.getInstance(LoginPage.class).getVersion();
		System.out.println(version);
		Assert.assertEquals(version, "UAT V1.0 r.5782    07/11/2024");
	}
	
	
	@Test(priority = 4,enabled = true)
	@Parameters(value = {"username", "password"})
	public void doLogin(String username,String password) {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(username, password);
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "CODER STATS");
	}
}
