package com.lqs.hrm;

public class TestRandom {
	public static void main(String[] args) {
		int yes = 0, no = 0;
		for(int i = 0; i < 100000; i++) {
			int num = (int)(Math.random()*100000+1);
			if (num < 10) {
				//System.out.println("中奖======================================================");
				yes++;
			}else {
				//System.out.println("未中奖--");
				no++;
			}
		}
		System.out.println("中奖次数："+yes);
		System.out.println("未中奖次数："+no);
	}
}
