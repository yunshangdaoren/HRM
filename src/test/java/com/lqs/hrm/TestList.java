package com.lqs.hrm;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<Stu> list = new ArrayList<Stu>();
		Stu stu1 = new Stu(1);
		Stu stu2 = new Stu(2);
		Stu stu3 = new Stu(3);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		for (Stu stu : list) {
			System.out.println(stu);
		}
		setList(list);
		for (Stu stu : list) {
			System.out.println(stu);
		}
	}
	
	public static void setList(List<Stu> list) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setAge(9);
		}
	}
}
