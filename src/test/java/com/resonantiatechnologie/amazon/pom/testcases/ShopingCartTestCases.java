package com.resonantiatechnologie.amazon.pom.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.resonantiatechnologie.amazon.keyword.Keyword;
import com.resonantiatechnologie.amazon.pom.base.PomBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;
import com.resonantiatechnologie.amazon.pom.pages.ShopingCart;
import com.resonantiatechnologie.amazon.utility.Constant;

public class ShopingCartTestCases extends PomBase{
	ShopingCart shoping;
	AmazonSignIn amazon;
	OnlineShopingSiteInIndia online;
	SoftAssert softAssert;
	public ShopingCartTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		amazon = new AmazonSignIn();
		online = amazon.login();
		softAssert = new SoftAssert();
	}

	@Test
	public void verifyShopingCartPage() throws IOException {
		shoping = online.clickOnCartLink();
		softAssert.assertEquals(shoping.getPageTitle(), "Amazon Sing In");
		Keyword.setPageLoadTimeOut("seconds", 30);
		Keyword.selectFromDropdown("xpath", "//select[@name=\"quantity\"]", "2");
		Keyword.waitFor();
		shoping.clickOnProceedToCheckoutButton();
		Keyword.waitFor();
		Keyword.takeScreenShot();
		
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
