package com.lqs.hrm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	
	/**
	 * 非空判断
	 * @param str
	 * @return boolean
	 */
	public static Boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}else if(str.length() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断两个字符串是否相等
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static Boolean isEquqls(String str1, String str2) {
		if (str1==null || str2==null) {
			return false;
		}
		if ("".equals(str1) || "".equals(str2)) {
			return false;
		}
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据身份证获取出生日期
	 */
	public static String getBirthday(String idCard) {
		return idCard.substring(6, 10)+"-"+idCard.substring(10, 12)+"-"+idCard.substring(12, 14);
	}
	
	public static String getEmpJobId(Date date, int num) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date); 
		//2020-05-20
		if (num < 10) {
			return dateStr.substring(0,4) + dateStr.substring(5, 7)+ dateStr.substring(8, 10) + "00"+ String.valueOf(num + 1);
		}else if(num>10 && num <100) {
			return dateStr.substring(0,4) + dateStr.substring(5, 7)+ dateStr.substring(8, 10) + "0"+ String.valueOf(num + 1);
		}
		return dateStr.substring(0,4) + dateStr.substring(5, 7)+ dateStr.substring(8, 10) + String.valueOf(num + 1);
	}
}
