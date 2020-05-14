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
	
	
}
