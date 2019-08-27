package com.resonantiatechnologie.amazon.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public void propertyFileReaderMethod(){
		try {
			Constant.fis = new FileInputStream(Constant.propertyFilePath);
			Constant.property = new Properties();
			Constant.property.load(Constant.fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
