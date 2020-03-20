package com.lqs.hrm;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("1", 1);
		map.put("1", 2);
		map.put("1", 3);
		map.put("1", 4);
		map.put("1", 5);
		System.out.println(map.get("1"));
		System.out.println(map.size());
	}

	public static void test(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
	}
}
