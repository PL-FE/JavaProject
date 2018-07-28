package ims;

import java.io.IOException;
import java.util.Scanner;

public class ImsCtrl {
	static Scanner input = new Scanner(System.in);
	

	public static void main(String[] args) throws IOException {

		ImsDao imsDao = new ImsDao();
		MM();
		

	}

	public static void MM() throws IOException {
		while (true) {
			ImsCtrl.showMMenu();

			int sel = -1;
			while (true) {
				System.out.println("请输入你的选择：");
				sel = input.nextInt();
				if (sel < 0 || sel > 3) {
					System.out.println("输入有误，重新输入！");
				} else {
					break;
				}
			}

			switch (sel) {
			case 1:
				ImsCtrl.stu();
				break;
			case 2:
				ImsCtrl.teacher();
				break;
			case 0:
				ImsCtrl.exit();
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 老师功能
	 */
	private static void teacher() throws IOException {
		while (true) {
			System.out.println("请输入教师账号：");
			String uer = input.next();
			System.out.println("请输入教师密码：");
			String pwd = input.next();

			if (uer.equals("admin") && pwd.equals("123456")) {
				break;
			} else {
				System.out.println("账号或者密码不对，请重新输入！");
			}
		}
		ImsDao imsDao = new ImsDao();
		while (true) {
			ImsCtrl.showTcaMenu();

			int sel = -1;
			while (true) {
				System.out.println("请输入你的选择：");
				sel = input.nextInt();
				if (sel < 0 || sel > 6) {
					System.out.println("输入有误，重新输入！");
				} else {
					break;
				}
			}

			switch (sel) {
			case 1:
				imsDao.addStu();
				break;
			case 2:
				imsDao.findStu();
				break;
			case 3:
				imsDao.updateStu();
				break;
			case 4:
				imsDao.deleteStu();
				break;
			case 5:
				imsDao.saveStu();
				break;
			case 6:
				imsDao.findAll();
				break;
			case 0:
				MM();
				break;
			default:
				break;
			}
		}

	}

	/**
	 * 学生功能
	 * @throws IOException 
	 */
	private static void stu() throws IOException {
		ImsDao imsDao = new ImsDao();
		
		while (true) {
			int i = imsDao.jud();
			imsDao.readls(i);
			if (i != -1) {
				break;
			}
			
		}

		while (true) {
			ImsCtrl.showStuMenu();

			int sel = -1;
			while (true) {
				System.out.println("请输入你的选择：");
				sel = input.nextInt();
				if (sel < 0 || sel > 11) {
					System.out.println("输入有误，重新输入！");
				} else {
					break;
				}
			}

			switch (sel) {
			case 1:
				imsDao.findMe();
				break;
			case 2:
				imsDao.updatePwd();
				break;
			case 3:
				imsDao.findstuAll();
				break;
			case 4:
				imsDao.addFriend();
				break;
			case 5:
				imsDao.showFriend();
				break;
			case 6:
				imsDao.saveFriend();
				break;
			case 7:
				imsDao.Mes();
				break;
			case 8:
				imsDao.showMes();
				break;
			case 9:
				imsDao.deleFriend();
				break;
			case 10:
				imsDao.updateFriendRm();
				break;
			case 0:
				MM();
				break;
			default:
				break;
			}
		}

	}

	/**
	 * 主菜单
	 */
	public static void showMMenu() {
		System.out.println("---------------用户登陆---------------");
		System.out.println("|	1. 学生登陆                      	|");
		System.out.println("|	2. 老师登陆                      	|");
		System.out.println("|	0. 退出     	                 	|");

		System.out.println("---------------------------------");
	}

	/**
	 * 老师菜单
	 */
	public static void showTcaMenu() {
		System.out.println("|	1. 添加学生信息                      	|");
		System.out.println("|	2. 查询学生信息                      	|");
		System.out.println("|	3. 修改学生信息                      	|");
		System.out.println("|	4. 删除学生信息                    	|");
		System.out.println("|	5. 保存学生信息                    	|");
		System.out.println("|	6. 加载学生信息						|");
		System.out.println("|	0. 返回上一层							|");
		System.out.println("---------------------------------");
	}

	/**
	 * 学生菜单
	 */
	public static void showStuMenu() {
		System.out.println("|	1. 查询个人信息                     	|");
		System.out.println("|	2. 修改密码                   	   	|");
		System.out.println("|	3. 查询同学信息                      	|");
		System.out.println("|	4. 添加好友                 		   	|");
		System.out.println("|	5. 显示我的所有好友信息                 	|");
		System.out.println("|	6. 保存好友信息						|");
		System.out.println("|	7. 给好友留言							|");
		System.out.println("|	8. 查看我的留言板						|");
		System.out.println("|	9. 删除好友							|");
		System.out.println("|	10. 修改好友备注						|");
		System.out.println("|	0. 返回上一层							|");
		System.out.println("---------------------------------");
	}

	/**
	 * 退出程序
	 */
	public static void exit() {
		System.exit(1);
	}

}
