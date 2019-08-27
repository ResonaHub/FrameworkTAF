package com.resonantiatechnologie.amazon.keyword;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.resonantiatechnologie.amazon.utility.Constant;
import com.resonantiatechnologie.amazon.utility.ExcleFileReader;

public class KeywordExceutionClass {
	private static Method[] method;
	private static Keyword keyword;
	private static ExcleFileReader exclefilereader;
	private static String objectType;
	private static String object;
	private static String keywords;

	public KeywordExceutionClass() {
		keyword = new Keyword();
		method = keyword.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {
		KeywordExceutionClass keywordexecution = new KeywordExceutionClass();
		ExcleFileReader.setExcelFile(Constant.keywordTestFilePath, "SignInTestCase");
		String filepath= Constant.orFilepath;
		Constant.fis = new FileInputStream(filepath);
		Constant.property = new Properties(System.getProperties());
		Constant.property.load(Constant.fis);
		for (int i = 1; i < 12; i++) {
			 objectType = ExcleFileReader.getCellData(i, 3);
			 object = ExcleFileReader.getCellData(i, 4);
			 keywords = ExcleFileReader.getCellData(i, 5);
			 executeReflection();
		}
		
	}
	
	private static void executeReflection() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(Method methods: method) {
			if(methods.getName().equals(keywords)) {
				methods.invoke(keyword);
			}
			
		}
	}

}
