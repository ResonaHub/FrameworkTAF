
package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.pom.base.PomBase;
import com.resonantiatechnologie.amazon.utility.Constant;

public class AmazonSignIn extends PomBase {
	
	// Obeject repository

	@FindBy(xpath = "//*[@class='a-link-nav-icon' or @href='/ref=ap frn logo']")
	WebElement amazonLogoLink;
	@CacheLookup
	@FindBy(xpath = "//h1[text()]")
	WebElement loginLable;

	@FindBy(xpath = "//*[contains(text(),'Email or mobile phone number')]")
	WebElement emailOrMobilePhoneNumberLabel;

	@FindBy(xpath = "//*[@id='ap_email' or name='email']")
	WebElement emailOrMobilePhoneNumberTextbox;
	@CacheLookup

	@FindBy(xpath = "//*[@id=\"continue\"]/parent::span")
	WebElement continueButton;

	@FindBy(xpath = "//i[@class='a-icon a-icon-collapse']")
	WebElement needHelpExpandButton;

	@FindBy(xpath = "//*[contains(text(), 'help')]")
	WebElement needHelpLink;

	@FindBy(xpath = "//*[contains(text(), 'Forgot')]")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//*[contains(text(), 'Other issues with sign in')]")
	WebElement otherIssuesWithSignInLink;

	@FindBy(xpath = "//*[contains(text(), 'New to Amazon?')]")
	WebElement newToAmazonLabel;

	@FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
	WebElement createyourAmazonAccountButton;

	@FindBy(xpath = "//*[contains(text(), 'Conditions of Use')]")
	WebElement conditionsOfUseLink;

	@FindBy(xpath = "//*[contains(text(), 'Privacy Notice')]")
	WebElement priacyNoticeLink;

	@FindBy(xpath = "//*[contains(text(), 'Help')]")
	WebElement helpLink;

	@FindBy(xpath = "//*[contains(text(), '© 1996-2019, Amazon.com, Inc. or its affiliates')]")
	WebElement amazonAffiliatesLabel;
	
	@FindBy(xpath = "//label[@for=\"ap_password\"]")
	WebElement passwordLabel;
	
	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//*[@id='signInSubmit']")
	WebElement loginButton;
	
	// Constructor initilize pagefactory
	public AmazonSignIn() {
		PageFactory.initElements(Constant.driver, this);
	}
	// Webelement operations 
	public String getPageTitle() {
		return Constant.driver.getTitle();
	}
	
	public void clickOnAmazonLogo() {
		amazonLogoLink.click();
	}
	
	public boolean amazonLogoIsDisplayed() {
		return amazonLogoLink.isDisplayed();
	}

	public boolean loginLableIsDisplayed() {
		return loginLable.isDisplayed();
	}
	
	public String getTextOfLoginLable() {
		return loginLable.getText();
	}

	public boolean emailOrMobilePhoneNumberLableIsDisplayed() {
		return emailOrMobilePhoneNumberLabel.isDisplayed();
	}
	
	public String getTextOFEmailOrMobilePhoneNumberLable() {
		return emailOrMobilePhoneNumberLabel.getText();
	}

	public void enterTextInEmailOrMobilePhoneNumberTextbox(String emailorphone) {
		emailOrMobilePhoneNumberTextbox.sendKeys(emailorphone);
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public void clickOnNeedHelpExpandButton() {
		needHelpExpandButton.click();
	}
	
	public void clickOnNeedHelpLink() {
		needHelpLink.click();
	}
	
	public void clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
	}
	
	public void clickOnOtherIssuesLink() {
		otherIssuesWithSignInLink.click();
	}
	
	public boolean newToAmazonLableIsDisplayed() {
		return newToAmazonLabel.isDisplayed();
	}
	
	public AmazonRegistration clickOnCreateYourAmazonAccount() {
		createyourAmazonAccountButton.click();
		return new AmazonRegistration();
	}

	public void clickOnConditionsOfUseLink() {
		conditionsOfUseLink.click();
	}
	
	public void clickOnPrivacyNotice() {
		priacyNoticeLink.click();
	}
	
	public void clickOnHelp() {
		helpLink.click();
	}
	
	public void entrePasswordInTextBox(String pass) {
		passwordTextBox.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public OnlineShopingSiteInIndia login() {
		emailOrMobilePhoneNumberTextbox.sendKeys(Constant.property.getProperty("USERNAME"));
		continueButton.click();
		passwordTextBox.sendKeys(Constant.property.getProperty("PASSWORD"));
		loginButton.click();
		return new OnlineShopingSiteInIndia(); 
	}
	
	public OnlineShopingSiteInIndia login(String username, String password) {
		emailOrMobilePhoneNumberTextbox.sendKeys(username);
		continueButton.click();
		passwordTextBox.sendKeys(password);
		loginButton.click();
		return new OnlineShopingSiteInIndia(); 
	}
}
