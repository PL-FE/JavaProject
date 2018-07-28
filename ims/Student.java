package ims;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * 学生信息：QQ号，密码，姓名，性别，年龄，电话，地址
 */
public class Student implements Serializable {
	private String qq;
	private String pwd;
	private String name;
	private String sex;
	private int age;
	private String tele;
	private String addre;

	 
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String qq, String pwd, String name, String sex, int age, String tele, String addre) {
		super();
		this.qq = qq;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tele = tele;
		this.addre = addre;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	@Override
	public String toString() {
		return "Student [qq=" + qq + ", pwd=" + pwd + ", name=" + name + ", sex=" + sex + ", age=" + age + ", tele="
				+ tele + ", addre=" + addre + "]";
	}
	
	public String toString2() {
		return "Student [qq=" + qq + ", pwd=" + "***" + ", name=" + name + ", sex=" + sex + ", age=" + age + ", tele="
				+ tele + ", addre=" + addre + "]";
	}



	

	
}
