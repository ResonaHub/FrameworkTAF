package com.resonantiatechnologie.amazon.pom.testcases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.resonantiatechnologie.amazon.keyword.Keyword;
import com.resonantiatechnologie.amazon.pom.base.PomBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;
import com.resonantiatechnologie.amazon.utility.Constant;
import com.resonantiatechnologie.amazon.utility.ExcleFileReader;
import com.resonantiatechnologie.amazon.utility.MySqlReader;


public class AmazonSignInTestCases extends PomBase {
	AmazonSignIn amazon;
	static Logger log = Logger.getLogger(AmazonSignInTestCases.class);

	public AmazonSignInTestCases() {
		super();
	}

	@BeforeMethod
	public void setup() {
		openBrowser();
		amazon = new AmazonSignIn();
	}
	
	@Test
	public void verifyLoginTest() {
		amazon.login();
		Assert.assertEquals(amazon.getPageTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		log.info("Login test pased sucessfully");
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
}
