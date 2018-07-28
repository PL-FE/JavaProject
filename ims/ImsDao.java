package ims;

import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImsDao {
	private static ArrayList<Student> stus = new ArrayList<Student>();
	private Scanner in = new Scanner(System.in);
	static {
		readStus();
	}

	private static void readStus() {
		try (ObjectInputStream oos = new ObjectInputStream(
				new FileInputStream("E:/pl/data/ims.data"));) {
			stus = (ArrayList<Student>) oos.readObject();
		} catch (Exception e) {
			// e.printStackTrace();
			stus = new ArrayList<Student>();
		}
	}

	/**
	 * 增加学生信息
	 */
	public void addStu() {
		String qq = null;
		while (true) {
			boolean a = true;

			System.out.println("请输入qq号：");
			qq = in.next();
			for (Student s : stus) {
				if (s.getQq().equals(qq)) {
					a = false;
					break;
				}
			}
			if (!a) {
				System.out.println("重复！");
			} else {
				break;
			}
		}

		String pwd;
		System.out.println("请输入密码：");
		pwd = in.next();

		String name;
		System.out.println("请输入姓名：");
		name = in.next();

		int sex;
		while (true) {
			System.out.println("请输入学生的性别（0：女   1：男）：");
			sex = in.nextInt();
			if (0 != sex && 1 != sex) {
				System.out.println("输入有误，只能选择0或1！");
			} else {
				break;
			}
		}
		String sexx;
		if (sex == 0) {
			sexx = "女";
		} else {
			sexx = "男";
		}

		int age;
		while (true) {
			System.out.println("请输入学生的年龄：");
			age = in.nextInt();
			if (age > 0 && age <= 100) {
				break;
			} else {
				System.out.println("年龄有误，年龄范围只能是1-100！");
			}
		}

		String tele;
		System.out.println("请输入电话：");
		tele = in.next();

		String addre;
		System.out.println("请输入地址：");
		addre = in.next();
		Student t = new ims.Student(qq, pwd, name, sexx, age, tele, addre);
		stus.add(t);
		System.out.println(t);

	}

	/**
	 * 查询学生信息
	 */
	public void findStu() {
		System.out.println("|	1. 根据指定qq号查询                   	|");
		System.out.println("|	2. 根据姓名模糊查询                    	|");
		System.out.println("|	3. 根据年龄段查询                      	|");
		int sel = -1;
		while (true) {
			while (true) {
				System.out.println("请输入你的选择：");
				sel = in.nextInt();
				if (sel < 0 || sel > 4) {
					System.out.println("输入有误，重新输入！");
				} else {
					break;
				}
			}
			switch (sel) {
			case 1:
				System.out.print("根据学号查询，");
				int index = getIndex();
				if (-1 == index) {
					System.out.println("查无此人");
				} else {
					System.out.println(stus.get(index));
				}

				break;
			case 2:
				System.out.println("根据姓名模糊查询,请输入关键字：");
				String name = in.next();
				Pattern pattern = Pattern.compile(name);
				for (int i = 0; i < stus.size(); i++) {
					Matcher matcher = pattern.matcher((stus.get(i)).getName());
					if (matcher.find()) {
						System.out.println(stus.get(i));
					}
				}

				break;
			case 3:
				System.out.println("根据年龄段查询，请输入年龄（年龄之间空格隔开）：");
				int st = in.nextInt();
				int en = in.nextInt();

				for (Student s : stus) {
					if (s.getAge() <= en && s.getAge() >= st) {
						System.out.println(s);
					}
				}

				break;

			default:
				break;
			}
			break;

		}

	}

	/**
	 * 修改学生信息
	 */
	public void updateStu() {
		findAll();
		System.out.println("请输入要修改的qq号：");
		int i = getIndex();
		if (-1 == i) {
			System.out.println("查无此人");
		} else {
			System.out.println("请输入新的qq号：");
			stus.get(i).setQq(in.next());

			System.out.println("请输入新的密码：");
			stus.get(i).setPwd(in.next());

			System.out.println("请输入新的姓名：");
			stus.get(i).setName(in.next());

			int sex;
			System.out.println("请输入新的性别：");
			while (true) {
				System.out.println("请输入学生的性别（0：女   1：男）：");
				sex = in.nextInt();
				if (0 != sex && 1 != sex) {
					System.out.println("输入有误，只能选择0或1！");
				} else {
					break;
				}
			}
			String sexx;
			if (sex == 0) {
				sexx = "女";
			} else {
				sexx = "男";
			}

			stus.get(i).setSex(sexx);

			int age;
			while (true) {
				System.out.println("请输入学生的新年龄：");
				age = in.nextInt();
				if (age > 0 && age <= 100) {
					break;
				} else {
					System.out.println("年龄有误，年龄范围只能是1-100！");
				}
			}
			stus.get(i).setAge(age);

			System.out.println("请输入新的电话：");
			stus.get(i).setTele(in.next());

			System.out.println("请输入新的地址：");
			stus.get(i).setAddre(in.next());
			System.out.println("修改成功！");

		}

	}

	/**
	 * 删除学生信息
	 */
	public void deleteStu() {
		int index = getIndex();
		if (-1 == index) {
			System.out.println("该qq不存在");
		} else {
			stus.remove(index);

		}
		System.out.println("删除成功！");

	}

	/**
	 * 保存学生信息
	 * 
	 * @throws IOException
	 */
	public void saveStu() throws IOException {
		FileOutputStream out = new FileOutputStream(new File("E:/pl/data/ims.data"));
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(stus);
		objOut.flush();
		objOut.close();
		System.out.println("文件保存成功！");

	}

	/**
	 * 加载学生信息
	 */
	public void findAll() {
		for (Student s : stus) {
			System.out.println(s);
		}

	}

	/**
	 * 获取学生在数组里面的下标
	 * 
	 * @return 数组下标
	 */
	public int getIndex() {
		System.out.println("请输入学生的qq号：");
		String num = in.next();
		int i = -1;
		for (int j = 0; j < stus.size(); j++) {
			if (stus.get(j).getQq().equals(num)) {
				i = j;
			}
		}

		return i;
	}

	/**
	 * 验证学生用户名密码
	 */
	static int i;

	public int jud() {

		System.out.println("请输入学生用户名：");
		String uer = in.next();

		System.out.println("请输入学生密码：");
		String pwd = in.next();

		if (stus.size() == 0) {
			System.out.println("没有该生记录！");

			return -1;
		}
		for (i = 0; i < stus.size(); i++) {
			if (stus.get(i).getQq().equals(uer) && stus.get(i).getPwd().equals(pwd)) {
				System.out.println("登陆成功！");
				return i;
			}
		}
		System.out.println("账号或者密码不对，请重新输入！");
		return -1;
	}

	// ============学生功能=================

	ArrayList<Friend> ls = new ArrayList<Friend>();// qq，备注
	{

	}
	ArrayList<Friend> ly = new ArrayList<Friend>();// 留言

	public void readls(int i) {
		System.out.println("读了" + stus.get(i).getQq() + "的好友");
		try (ObjectInputStream oos = new ObjectInputStream(
				new FileInputStream("E:/pl/data/" + stus.get(i).getQq() + "好友信息.data"));) {
			ls = (ArrayList<Friend>) oos.readObject();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void readluiyan(int i) {
		{
			System.out.println("读了" + stus.get(i).getQq() + "的留言");
			System.out.println(stus.get(i));
			try (ObjectInputStream oos = new ObjectInputStream(
					new FileInputStream("E:/pl/data/" + stus.get(i).getQq() + "的留言.data"));) {
				ly = (ArrayList<Friend>) oos.readObject();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
	}

	/**
	 * 查询个人信息
	 */
	public void findMe() {

		System.out.println("我的个人信息：");
		System.out.println(stus.get(i));

	}

	/**
	 * 修改密码
	 */
	public void updatePwd() {
		System.out.println("请输入您的原始密码：");
		String pwd = in.next();
		while (true) {
			if (pwd.equals(stus.get(i).getPwd())) {
				break;
			}
			System.out.println("密码不正确，请重新输入！");
		}

		while (true) {
			System.out.println("请输入您的新密码：");
			pwd = in.next();
			System.out.println("请再次输入您的新密码：");
			String pwd2 = in.next();
			if (pwd.equals(pwd2)) {
				stus.get(i).setPwd(pwd2);
				break;
			}
			System.out.println("两次密码不一致，请重新输入！");

		}

	}

	/**
	 * 查询同学
	 */
	public void findstuAll() {
		for (int j = 0; j < stus.size(); j++) {
			if (!stus.get(j).equals(stus.get(i))) {
				System.out.println(stus.get(j).toString2() + " ");
				int k = 0;
				for (int i = 0; i < ls.size(); i++) {
					if (stus.get(j).getQq().equals(ls.get(i).getQq())) {
						System.out.println("true");
						k = 1;
					}
				}
				if (k == 0) {
					System.out.println("false");
				}

			}

		}

	}

	/**
	 * 添加好友
	 * 
	 * @throws IOException
	 */
	public void addFriend() throws IOException {
		String a;
		while (true) {
			System.out.println("请输入要添加好友的qq号：");
			a = in.next();
			if (!a.equals(stus.get(i).getQq())) {
				break;
			}
			System.out.println("好友不能为自己！");
		}
		System.out.println("备注：");
		String b = in.next();
		ls.add(new Friend(a, b));
		saveFriend();
		System.out.println("好友已添加成功！");
	}

	/**
	 * 显示我的好友信息
	 */
	public void showFriend() {

		for (Friend friend : ls) {
			System.out.print(friend.getBeizhu() + ":");
			for (int i = 0; i < stus.size(); i++) {
				if (stus.get(i).getQq().equals(friend.getQq())) {
					System.out.println(stus.get(i).toString2());
				}
			}
		}

	}

	/**
	 * 保存好友信息
	 * 
	 * @throws IOException
	 */
	public void saveFriend() throws IOException {
		FileOutputStream out = new FileOutputStream(
				new File("E:/pl/data/" + stus.get(i).getQq() + "好友信息.data"));
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(ls);
		objOut.flush();
		objOut.close();
		System.out.println("好友信息保存成功！");

	}

	/**
	 * 给好友留言
	 * 
	 * @throws IOException
	 */
	public void Mes() throws IOException {

		System.out.println("请输入要留言的好友qq");
		String hyq = in.next();

		for (int j = 0; j < ls.size(); j++) {
			if (ls.get(j).getQq().equals(hyq)) {
				System.out.println("请输入留言：");
				String liuyan = in.next();
				ly.add(new Friend(stus.get(i).getQq()+"给你留言:"+liuyan));
			}
			System.out.println("给" + hyq + "留言");
			FileOutputStream out = new FileOutputStream(new File("E:/pl/data/" + hyq + "的留言.data"),true);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(ly);
			objOut.flush();
			objOut.close();
			System.out.println("好友信息保存成功！");
		}

	}

	/**
	 * 查看我的留言板
	 */
	public void showMes() {
		ArrayList<Friend> lyy = new ArrayList<Friend>();// 留言
		System.out.println("读了" + stus.get(i).getQq() + "的留言");
		//System.out.println("i为" + i);
		//System.out.println(stus.get(i));
		try (ObjectInputStream oos = new ObjectInputStream(
				new FileInputStream("E:/pl/data/" + stus.get(i).getQq() + "的留言.data"));) {
			lyy = (ArrayList<Friend>) oos.readObject();
		} catch (Exception e) {
			// e.printStackTrace();
		}

		for (Friend friend : lyy) {
			System.out.println(friend.getLiuyan());
		}
	}

	/**
	 * 删除好友
	 */
	public void deleFriend() {
		showFriend();
		System.out.println("请输入要删除的好友的qq：");
		String deqq = in.next();
		for (int j = 0; j < ls.size(); j++) {
			if (ls.get(j).getQq().equals(deqq)) {
				ls.remove(j);
			} else {
				System.out.println("此好友不存在！");
			}
		}
		try {
			saveFriend();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 修改好友备注
	 */
	public void updateFriendRm() {
		showFriend();

		boolean aa = true;
		String qq = null;
		while (aa) {
			System.out.println("请输入要修改好友备注的qq号：");
			qq = in.next();
			for (int i = 0; i < ls.size(); i++) {
				if (qq.equals(ls.get(i).getQq())) {
					System.out.println("请输入要修改后好友备注:");
					String nr = in.next();
					ls.set(i, new Friend(qq, nr));
					aa = false;
					break;
				} else {
					System.out.println("你们不是好友！");
				}

			}

		}
		try {
			saveFriend();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
