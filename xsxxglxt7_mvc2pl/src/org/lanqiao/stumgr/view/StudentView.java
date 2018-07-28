package org.lanqiao.stumgr.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.lanqiao.stumgr.bean.Student;

public class StudentView {
	private Scanner input = new Scanner(System.in);

	/**
	 * 系统菜单
	 */
	public void showMenu() {
		System.out.println("---------------菜单---------------");
		System.out.println("|	1. 增加一个学生                      	|");
		System.out.println("|	2. 修改学生信息                      	|");
		System.out.println("|	3. 删除一个学生                      	|");
		System.out.println("|	4. 查询一个学生                    	|");
		System.out.println("|	5. 查询所有学生                    	|");
		System.out.println("|	0. 退出程序		|");
		System.out.println("---------------------------------");
	}
	
	public Student add() {
		String no;
		while(true){
			System.out.println("请输入学生的学号：");
			no = input.next(); 
			if(no.length() != 6){
				System.out.println("学号有误，长度必须为6位！");
			}else{
				break;
			}
		}
		
		System.out.println("请输入学生的姓名：");
		String name = input.next();
		
		String idCard ;
		while(true){
			System.out.println("请输入学生的身份证号：");
			idCard = input.next();
			if(idCard.length() != 18){
				System.out.println("身份证号有误，长度必须为18位！");
			}else{
				break;
			}
		}
		
		int sex;
		while(true){
			System.out.println("请输入学生的性别（0：女   1：男）：");
			sex = input.nextInt();
			if(0 != sex && 1 != sex){
				System.out.println("输入有误，只能选择0或1！");
			}else{
				break;
			}
		}
		
		int age;
		while(true){
			System.out.println("请输入学生的年龄：");
			age = input.nextInt();
			if(age > 0 && age <= 100){
				break;
			}else{
				System.out.println("年龄有误，年龄范围只能是1-100！");
			}
		}
		
		return new Student(no, name, idCard, sex, age);
	}

	public Student update() {
		return this.add();
	}

	public String getNo() {
		System.out.println("请输入学生的学号：");
		return input.next();
	}

	public void show(Student stu) {
		System.out.println(stu);
	}

	public void showAll(ArrayList<Student> list) {
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	
	public void showInfo(boolean ret) {
		if(ret) {
			System.out.println("操作成功！");
		}else {
			System.out.println("操作失败！");
		}
	}
}
