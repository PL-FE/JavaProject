package org.lanqiao.stumgr.bean;

import java.io.Serializable;

/**
 * 学生
 * @author lsy
 */
public class Student implements Serializable{
	/** 学号（6位）*/
	private String no ;
	/** 姓名*/
	private String name;
	/** 身份证（18位）*/
	private String idCard;
	/** 性别（0：女   1：男）*/
	private Integer sex ;
	/** 年龄（1-100）*/
	private Integer age;
	
	public Student(){}

	public Student(String no, String name, String idCard, Integer sex, Integer age) {
		super();
		this.no = no;
		this.name = name;
		this.idCard = idCard;
		this.sex = sex;
		this.age = age;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", idCard=" + idCard + ", sex=" + sex + ", age=" + age + "]";
	}

	
}
