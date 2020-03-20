package com.lqs.hrm.util;

/**
 * 随机数字工具类
 * @author Administrator
 *
 */
public class RandomNumberUtil {
	
	/**
	 * 获取随机6位数
	 * @return
	 */
	public static Integer getRandomSixDigitNumber() {
		return (int)((Math.random()*9+1)*100000);
	}
	
}
