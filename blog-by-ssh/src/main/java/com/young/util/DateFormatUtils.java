package com.young.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String toyyyyMMddHHmmss(Date date){
		return sdf1.format(date);
	}

	public static String toyyyyMMdd(Date date){
		return sdf2.format(date);
	}
}
