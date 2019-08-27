package com.resonantiatechnologie.amazon.utility;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.Screenshot;

public class Constant {
	// selenium constants
	public static WebDriver driver;
	public static Actions action;
	public static WebElement element;
	public static Screenshot sceenshot;
	public static Select select;

	// java constants
	public static Properties property;
	public static FileInputStream fis;
	public static List list;
	public static File file;
	public static Robot robot;
	public static FileOutputStream fos;

	// generic constants
	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 100;

	// file paths
	public static String propertyFilePath = "I:\\WorkspaceEclips\\Framework\\src\\main\\resources\\config\\config.properties";
	public static String pomexcleFilePath = "I:\\WorkspaceEclips\\Framework\\src\\main\\java\\com\\resonantiatechnologie\\amazon\\testdata\\PomTestData.xlsx";
	public static String keywordTestFilePath = "I:\\WorkspaceEclips\\Framework\\src\\main\\java\\com\\resonantiatechnologie\\amazon\\testdata\\KeywordTestCases.xlsx";
	public static String orFilepath = "I:\\WorkspaceEclips\\Framework\\src\\main\\resources\\config\\OR.properties";
}
