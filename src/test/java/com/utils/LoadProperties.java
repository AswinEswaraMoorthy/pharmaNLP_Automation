package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadProperties {

	public static String getProperties(String key) throws Throwable {

		String userdir = System.getProperty("user.dir");
		FileInputStream fileInputStream = new FileInputStream(userdir +"\\config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}

}
