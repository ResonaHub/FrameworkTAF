package com.resonantiatechnologie.amazon.utility;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.resonantiatechnologie.amazon.keyword.Keyword;

public class TestNgListener implements ITestListener {
	static Logger log = Logger.getLogger(TestNgListener.class);

	public void onTestStart(ITestResult result) {
		log.info("Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test Sucessed");
		try {
			Keyword.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		log.error("Test Failed");
		log.info("Screenshot is taken and test failed");
		try {
			Keyword.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		log.error("Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		log.info("Test Started");

	}

	public void onFinish(ITestContext context) {
		log.info("Test Finished");

	}

}
