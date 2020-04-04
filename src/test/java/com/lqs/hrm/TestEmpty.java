package com.lqs.hrm;

public class TestEmpty {
	public static void main(String[] args) {
		String str = "";
		if (str == null || "".equals(str.trim())) {
			System.out.println("非空");
		}else {
			System.out.println("空");
		}
	}
}
