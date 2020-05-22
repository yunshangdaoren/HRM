package com.lqs.hrm;


import java.util.Scanner;

public class TestJava {

	public static void main(String[] args) {
		String stuName, stuAge;
		Scanner scanner = new Scanner(System.in);
		boolean isRun = true;
		int choose;
		while(isRun){
			System.out.println("请选择：");
			System.out.println("1.录入学生信息：");
			System.out.println("2.退出系统");
			choose = scanner.nextInt();
			if (choose == 1) {
				addStuInfo(scanner);
			}else {
				isRun = false;
			}
		}
	}
	
	public static void addStuInfo(Scanner scan) {
		System.out.println("请输入学生姓名:");
		String stuName = scan.next();
	}

}
