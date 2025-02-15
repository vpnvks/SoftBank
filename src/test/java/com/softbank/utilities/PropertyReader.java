package com.softbank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	Properties pr;
	

	public PropertyReader() {
		File PropertyFile = new File(System.getProperty("user.dir")+"/configuration/config.properties");
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(PropertyFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pr = new Properties();
		try {
			pr.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String geturl() {
		return pr.getProperty("url");
		
	}
}
