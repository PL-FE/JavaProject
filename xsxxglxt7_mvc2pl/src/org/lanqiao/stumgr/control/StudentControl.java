package org.lanqiao.stumgr.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.lanqiao.stumgr.bean.Student;
import org.lanqiao.stumgr.service.StudentService;
import org.lanqiao.stumgr.view.StudentView;

public class StudentControl {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StudentService studentService = new StudentService();
		StudentView studentView = new StudentView();
		
		while(true){
			studentView.showMenu();
			
			int sel = -1;
			while(true){
				System.out.println("请输入你的选择：");
				sel = input.nextInt();
				if(sel < 0 || sel > 5){
					System.out.println("输入有误，重新输入！");
				}else{
					break;
				}
			}
			
			switch (sel) {
			case 1:
				Student stu = studentView.add();
				boolean ret = studentService.add(stu);
				studentView.showInfo(ret);
				break;
			case 2:
				stu = studentView.update();
				ret = studentService.update(stu);
				studentView.showInfo(ret);
				break;
			case 3:
				String no = studentView.getNo();
				ret = studentService.deleteByNo(no);
				studentView.showInfo(ret);
				break;
			case 4:
				no = studentView.getNo();
				stu = studentService.selectById(no);
				studentView.show(stu);
				break;
			case 5:
				ArrayList<Student> list = studentService.listAll();
				studentView.showAll(list);
				break;
			case 0:
				System.exit(1);//退出程序
				break;
			default:
				break;
			}
		}
		
	}

}
