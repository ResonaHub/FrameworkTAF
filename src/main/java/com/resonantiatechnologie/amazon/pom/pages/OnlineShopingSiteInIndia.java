package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.pom.base.PomBase;
import com.resonantiatechnologie.amazon.utility.Constant;

public class OnlineShopingSiteInIndia extends PomBase {

	// Object repository
	@FindBy(xpath = "//*[@id='nav-tools']/child::a[@id=\"nav-link-yourAccount\"]")
	WebElement helloYourOrdersLink;

	@FindBy(xpath = "//*[@id='nav-tools']/child::a[@id=\"nav-link-prime\"]")
	WebElement tryPrimeLink;

	@FindBy(xpath = "//*[@id='nav-tools']/child::a[@id=\"nav-link-wishlist\"]")
	WebElement yourListsLink;

	@FindBy(xpath = "//*[@id='nav-tools']/child::a[@id=\"nav-cart\"]")
	WebElement cartLink;

	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
	WebElement searchTextBox;
	
	@FindBy(xpath = "//span[@id=\"nav-search-submit-text\"]")
	WebElement searchSubmitButton;
	// Constructor initilize page factory
	public OnlineShopingSiteInIndia() {
		PageFactory.initElements(Constant.driver, this);
	}

	// Webelement operations

	public String getTitle() {
		return Constant.driver.getTitle();
	}

	public YourAccount clickOnHelloYourOrdersLink() {
		helloYourOrdersLink.click();
		return new YourAccount();
	}

	public void mouseHoverOnhelloSignInYourOrdersLink() {
		Constant.action = new Actions(Constant.driver);
		Constant.action.moveToElement(helloYourOrdersLink).build().perform();
	}

	public AmazonPrime clickOnTryPrimeLink() {
		tryPrimeLink.click();

		return new AmazonPrime();

	}

	public void mouseHoverOnTryPrimeLink() {
		Constant.action = new Actions(Constant.driver);
		Constant.action.moveToElement(tryPrimeLink).build().perform();
	}

	public void clickOnYourListsLink() {
		yourListsLink.click();
	}

	public void mouseHoverOnYourListsLink() {
		Constant.action = new Actions(Constant.driver);
		Constant.action.moveToElement(yourListsLink).build().perform();
	}

	public ShopingCart clickOnCartLink() {
		cartLink.click();
		return new ShopingCart();
	}

	public void enterTextToSearchBox(String text) {
		searchTextBox.sendKeys(text);
	}
	
	public void clickOnSearchSubmitButton() {
		searchSubmitButton.click();
		
	}
}
