package com.resonantiatechnologie.amazon.keyword;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.resonantiatechnologie.amazon.utility.Constant;
import com.resonantiatechnologie.amazon.utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	// initilize the logger

	static Logger log = Logger.getLogger(Keyword.class);

	/**
	 * opens the mentioned browser
	 * 
	 * @param browsername browsername eg chrome, firefox, ie
	 */
	public static void openBrowser(String browsername) {
		String browserName = browsername;
		log.info("Opening " + browserName + " browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Constant.driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Constant.driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			Constant.driver = new InternetExplorerDriver();
		} else {
			log.error("Failed to open browser");
		}
		log.info("Opened " + browserName + " browser");
	} // end of method

	/**
	 * opens the mentioned url
	 * 
	 * @param urlname string url e.g. https://www.zyz.com
	 */
	public static void openUrl(String url) {
		log.info("Launching " + url);
		Constant.driver.get(url);
		log.info("Launched " + url);

	} // end of method

	/**
	 * miximize the current window
	 */
	public static void maximizeWindow() {
		Constant.driver.manage().window().maximize();
		log.info("Maximizing window");

	} // end of method

	/**
	 * sets the page load time out
	 * 
	 * @param timeunit string timeunit e.g. seconds, minutes time long time
	 */
	public static void setPageLoadTimeOut(String timeunit, long time) {
		long timelocal = time;
		log.info("Setting page load time");
		
		if (timeunit.equalsIgnoreCase("seconds")) {
			Constant.driver.manage().timeouts().pageLoadTimeout(timelocal, TimeUnit.SECONDS);
		} else if (timeunit.equalsIgnoreCase("microseconds")) {
			Constant.driver.manage().timeouts().pageLoadTimeout(timelocal, TimeUnit.MICROSECONDS);
		} else if (timeunit.equalsIgnoreCase("milliseconds")) {
			Constant.driver.manage().timeouts().pageLoadTimeout(timelocal, TimeUnit.MILLISECONDS);
		} else if (timeunit.equalsIgnoreCase("minutes")) {
 			Constant.driver.manage().timeouts().pageLoadTimeout(timelocal, TimeUnit.MINUTES);
		} else if (timeunit.equalsIgnoreCase("nanoseconds")) {
			Constant.driver.manage().timeouts().pageLoadTimeout(timelocal, TimeUnit.NANOSECONDS);
		} else if (timeunit.equalsIgnoreCase("hours")) {
			Constant.driver.manage().timeouts().pageLoadTimeout(timelocal, TimeUnit.HOURS);
		} else {
			log.error("Invalid timeunit");
		}

	} // end of method

	/**
	 * sets the implicit wait for driver instance
	 * 
	 * @param timeunit string timeunit e.g. seconds, minutes time long time
	 */
	public static void setImplicitlyWait(String timeunit, long time) {
		long timelocal = time;
		log.info("Setting implicit wait");
		if (timeunit.equalsIgnoreCase("seconds")) {
			Constant.driver.manage().timeouts().implicitlyWait(timelocal, TimeUnit.SECONDS);
		} else if (timeunit.equalsIgnoreCase("microseconds")) {
			Constant.driver.manage().timeouts().implicitlyWait(timelocal, TimeUnit.MICROSECONDS);
		} else if (timeunit.equalsIgnoreCase("milliseconds")) {
			Constant.driver.manage().timeouts().implicitlyWait(timelocal, TimeUnit.MILLISECONDS);
		} else if (timeunit.equalsIgnoreCase("minutes")) {
			Constant.driver.manage().timeouts().implicitlyWait(timelocal, TimeUnit.MINUTES);
		} else if (timeunit.equalsIgnoreCase("nanoseconds")) {
			Constant.driver.manage().timeouts().implicitlyWait(timelocal, TimeUnit.NANOSECONDS);
		} else if (timeunit.equalsIgnoreCase("hours")) {
			Constant.driver.manage().timeouts().implicitlyWait(timelocal, TimeUnit.HOURS);
		} else {
			log.error("Invalid timeunit");

		}
	} // end of method
	
	/**
	 * 
	 * @param locatortype
	 * @param locatorvalue
	 * @param text
	 */
	public static void enterText(String locatortype, String locatorvalue, String text) {
		getElement(locatortype, locatorvalue).sendKeys(text);
	} // end of method
	 
	/*
	 * deletes all cokies of browser
	 */
	public static void deleteAllCokies() {
		log.info("Deleting all browser cookies");
		Constant.driver.manage().deleteAllCookies();
		log.info("Deleted all cookies");
	} // end of method

	/*
	 * method quits the browser
	 */
	public static void closeBrowser() {
		log.info("Closing browser");
		Constant.driver.quit();
		log.info("Closed browser");

	} // end of method

	/*
	 * close the current window, to which webdriver instance is pointing
	 */
	public static void closeCurrentWindow() {
		log.info("Closing window");
		Constant.driver.close();
		log.info("Closed window");

	} // end of method

	/*
	 * refresh the current webpage
	 */
	public static void relodePage() {
		log.info("Refreshing webpage");
		Constant.driver.navigate().refresh();
	} // end of method

	/**
	 * gets the title of webpage to which webdriver instance is pointing
	 * 
	 * @return pagetitle
	 */
	public static String getPageTitle() {
		log.info("Getting page title ");
		return Constant.driver.getTitle();
	} // end of method

	/**
	 * get current url of webpage to which webdriver instance is pointing
	 * 
	 * @return current url
	 * 
	 */
	public static String getCurrentUrl() {
		log.info("Getting current page url ");
		return Constant.driver.getCurrentUrl();
	} // end of method

	/**
	 * gets the window handle of currently pointing window by webdriver instance
	 * 
	 * @return window handle string handle
	 */
	public static String getWindowHandle() {
		log.info("Getting window handle ");
		return Constant.driver.getWindowHandle();
	} // end of method

	/**
	 * gets the handles of multiple window opened in browser
	 * 
	 * @return window handles set of window handles
	 */
	public static Set<String> getWindowHandles() {
		log.info("Getting window handles ");
		return Constant.driver.getWindowHandles();
	} // end of method

	/**
	 * gets the webelement of the page
	 * 
	 * @param locatortype  string locatortype e.g. xath
	 * @param locatorvalue
	 * @return
	 */
	public static WebElement getElement(String locatortype, String locatorvalue) {
		String locatorType = locatortype;
		log.info("Locating " + locatorType);
		if (locatorType.equalsIgnoreCase("xpath")) {
			Constant.element = Constant.driver.findElement(By.xpath(locatorvalue));
		} else if (locatorType.equalsIgnoreCase("cssSelector")) {
			Constant.element = Constant.driver.findElement(By.cssSelector(locatorvalue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			Constant.element = Constant.driver.findElement(By.id(locatorvalue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			Constant.element = Constant.driver.findElement(By.name(locatorvalue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			Constant.element = Constant.driver.findElement(By.tagName(locatorvalue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			Constant.element = Constant.driver.findElement(By.className(locatorvalue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			Constant.element = Constant.driver.findElement(By.linkText(locatorvalue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			Constant.element = Constant.driver.findElement(By.partialLinkText(locatorvalue));
		} else {
			log.error("Invalid locatortype or locatorvalue");
		}
		return Constant.element;
	} // end of method

	/**
	 * dismiss the alerts
	 */
	public static void dismissAlert() {
		log.info("Disissing alert ");
		Constant.driver.switchTo().alert().dismiss();
		log.info("Dismised alert ");
	} // end of method

	/**
	 * accepts the alerts
	 */
	public static void acceptAlert() {
		Constant.driver.switchTo().alert().accept();
		log.info("Accepted alter ");
	} // end of method

	/**
	 * gets the text of alert
	 * 
	 * @return alert text string type
	 */
	public static String getTextOfAlert() {
		log.info("Getting text of alert ");
		return Constant.driver.switchTo().alert().getText();
	} // end of method

	/**
	 * enters string text in alertbox
	 * 
	 * @param text
	 */
	public static void enterTextToAlert(String text) {
		log.info("Entering " + text + " to alert ");
		Constant.driver.switchTo().alert().sendKeys(text);
		log.info("Entred " + text + " to alert");

	} // end of method

	/**
	 * performs mouse hover to mentioned element
	 * 
	 * @param locatortype  string type like e.g. xpath
	 * @param locatorvalue
	 */
	public static void mouseHoverToElement(String locatortype, String locatorvalue) {
		log.info("Performing mouser hover ");
		Constant.action = new Actions(Constant.driver);
		Constant.action.moveToElement(getElement(locatortype, locatorvalue)).build().perform();
		log.info("Mouse hovred ");
	} // end of method

	/**
	 * switches to the desired frame
	 * 
	 * @param index int frame index
	 */
	public static void switchToFrame(int index) {
		log.info("Switching to frame");
		Constant.driver.switchTo().frame(index);
		log.info("Switched to frame");
	} // end of method

	/**
	 * switches to the desired frame
	 * 
	 * @param locatortype  string type like e.g. xpath
	 * @param locatorvalue
	 */
	public static void switchToFrame(String locatortype, String locatorvalue) {
		log.info("Switching to frame");
		Constant.driver.switchTo().frame(getElement(locatortype, locatorvalue));
		log.info("Switched to frame");
	} // end of method

	/**
	 * uploades the file to desired location
	 * 
	 * @param locatortype  string e.g. xpath
	 * @param locatorvalue
	 * @param filePath     string file path
	 */
	public static void uploadFile(String locatortype, String locatorvalue, String filePath) {
		log.info("Uploding file");
		getElement(locatortype, locatorvalue).sendKeys(filePath);
		log.info("Uploded file");
	} // end of method

	/**
	 * takes screenshot of currently pointing webpage
	 * 
	 * @param pathtosaveimage
	 * @throws IOException 
	 */
	public static void takeScreenShot() throws IOException {
		log.info("Taking screenshot");
		AShot as = new AShot();
		Date d = new Date();
		SimpleDateFormat Formatter = new SimpleDateFormat ("-E, dd MMM yyyy, HH_mm_ss");
		String DateFormat = Formatter.format(d);
		Screenshot sc = as.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Constant.driver);
		ImageIO.write(sc.getImage(),"PNG",new File("I:\\WorkspaceEclips\\Framework\\screenshot"+DateFormat+".png"));
		log.info("Screenshot taken and saved to location");
	}// end of method

	/**
	 * slects desired value from dropdown
	 * 
	 * @param locatortype  string locatortype e.g. xpath
	 * @param locatorvalue
	 * @param value        string value
	 */
	public static void selectFromDropdown(String locatortype, String locatorvalue, String value) {
		log.info("Selecting value from dropdown");
		Constant.select = new Select(getElement(locatortype, locatorvalue));
		Constant.select.selectByValue(value);
		log.info("Selected value from dropdown");
	} // end of method

	/**
	 * slects desired value from dropdown
	 * 
	 * @param locatortype  string locatortype e.g. xpath
	 * @param locatorvalue
	 * @param index        int index
	 */
	public static void selectFromDropdown(String locatortype, String locatorvalue, int index) {
		log.info("Selecting value from dropdown");
		Constant.select = new Select(getElement(locatortype, locatorvalue));
		Constant.select.selectByIndex(index);
		log.info("Selected value from dropdown");

	} // end of method

	/**
	 * sets web driver event listner
	 */
	public static void setupWebDriverEventListener() {
		EventFiringWebDriver eventdriver = new EventFiringWebDriver(Constant.driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		WebEventListener eventListener = new WebEventListener();
		eventdriver.register(eventListener);
		Constant.driver = eventdriver;

	} // end of method
	/**
	 * 
	 * @param locatortype
	 * @param locatorvalue
	 */
	public static void click(String locatortype, String locatorvalue) {
		getElement(locatortype, locatorvalue).click();
		
	} // end of method
	/**
	 * waits for some time
	 */
	public static void waitFor() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // end of method

} // end of class
