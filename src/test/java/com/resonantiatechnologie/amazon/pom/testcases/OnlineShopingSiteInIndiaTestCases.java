package com.resonantiatechnologie.amazon.pom.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.resonantiatechnologie.amazon.keyword.Keyword;
import com.resonantiatechnologie.amazon.pom.base.PomBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;
import com.resonantiatechnologie.amazon.utility.Constant;

public class OnlineShopingSiteInIndiaTestCases extends PomBase{
	AmazonSignIn amazon;
	OnlineShopingSiteInIndia online;

	public OnlineShopingSiteInIndiaTestCases(){
		super(); 
	}

	@BeforeMethod
	public void setup() {
		openBrowser();
		amazon = new AmazonSignIn();
		online = amazon.login();
	}

	@Test
	public void verifyPageTitleTest() throws IOException {
		Assert.assertEquals(online.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Keyword.takeScreenShot();

	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
