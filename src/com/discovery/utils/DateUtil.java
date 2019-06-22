package com.discovery.utils;

import java.util.Date;

public class DateUtil {
	public static String generateUserID(){
		String userID = String.format("%tY%tm%td%tH%tM%tS", new Date(),new Date(),new Date(),new Date(),new Date(),new Date());
		return userID;
	}
	
	public static String formatTime(String time){
		String year = time.substring(0, 4);
		String month = time.substring(4, 6);
		String day = time.substring(6, 8);
		String hours = time.substring(8, 10);
		String minutes = time.substring(10, 12);
		String seconds = time.substring(12, 14);
		String result = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
		return result;
	}
}
