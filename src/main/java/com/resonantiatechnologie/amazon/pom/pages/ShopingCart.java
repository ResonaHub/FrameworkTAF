package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.pom.base.PomBase;
import com.resonantiatechnologie.amazon.utility.Constant;

public class ShopingCart extends PomBase {
		
	@FindBy(xpath ="//input[@name=\"proceedToCheckout\"]")
	WebElement proceedToCheckoutButton;
	
	public ShopingCart() {
		PageFactory.initElements(Constant.driver, this);
	}
	
	
	
	public void clickOnProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
	}
	
	
	
	public String getPageTitle() {
		return Constant.driver.getTitle();
	}
}
