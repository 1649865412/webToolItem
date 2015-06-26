package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static String toString(Date date, String dateFormat) {
		if (date == null) {
			return "";
		}
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(date);
	}
	
	public static String getCurrent(){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(new Date());
	}
}
