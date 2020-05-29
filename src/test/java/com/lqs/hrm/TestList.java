package com.lqs.hrm;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Integer integer1 = new Integer(1);
		Integer integer2 = new Integer(2);
		Integer integer3 = new Integer(3);
		
		list.add(integer1);
		list.add(integer2);
		list.add(integer3);
		list.add(integer1);
		list.add(integer1);
		List<Integer> newList = list.stream().distinct().collect(Collectors.toList()); 
		for (Integer integer : newList
				) {
			
			System.out.println(integer);
		}
	}
	
}
