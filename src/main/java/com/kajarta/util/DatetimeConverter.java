package com.kajarta.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeConverter {
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_T_HH_MM = "yyyy-MM-dd'T'HH:mm";
	public static String toString(Date datetime, String format) {
		String result = "";
		try {
			if (datetime != null) {
				result = new SimpleDateFormat(format).format(datetime);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Date parse(String datetime, String format) {
		Date result = new Date();
		try {
			result = new SimpleDateFormat(format).parse(datetime);
		} catch (Exception e) {
			result = new Date();
			e.printStackTrace();
		}
		return result;
	}
}
