package com.softbank.utilities;

public class DataTypeConverter {
	
	public static int convertToInt(Object obj) {
		
		double doubleValue = Double.parseDouble(obj.toString());
		 return (int) Math.floor(doubleValue);
		
	}
	
	public static String convertToString(Object obj) {
		return obj.toString();
		
	}

}
