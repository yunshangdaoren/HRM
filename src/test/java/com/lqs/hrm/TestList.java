package com.lqs.hrm;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
//		List<Stu> list = new ArrayList<Stu>();
//		Stu stu1 = new Stu(1);
//		Stu stu2 = new Stu(2);
//		Stu stu3 = new Stu(3);
//		list.add(stu1);
//		list.add(stu2);
//		list.add(stu3);
//		for (Stu stu : list) {
//			System.out.println(stu);
//		}
//		setList(list);
//		for (Stu stu : list) {
//			System.out.println(stu);
//		}
		
		List<Object> list = new ArrayList<>();
		String s1=null;
		String s2=null;
		list.add(s1);
		list.add(s2);
		list.add(null);
		list.add(null);
		System.out.println(list.size());
		for (Object object : list) {
			System.out.println(object);
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println("-------");
		}
		if (list.size() == 0 || list == null) {
			System.out.println("=======");
		}
	}
	
	public static void setList(List<Stu> list) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setAge(9);
		}
	}
}
