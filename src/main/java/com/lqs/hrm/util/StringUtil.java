package com.lqs.hrm.util;

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
}
