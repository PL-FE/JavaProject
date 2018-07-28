package ims;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Friend implements Serializable {
	String qq;
	String beizhu;
	String liuyan;

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getLiuyan() {
		return liuyan;
	}

	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}

	@Override
	public String toString() {
		return "Friend [qq=" + qq + ", beizhu=" + beizhu + "]";
	}

	public String t2() {
		return "留言=" + liuyan;
	}

	public Friend(String liuyan) {
		super();
		this.liuyan = liuyan;
	}

	public Friend(String qq, String beizhu) {
		super();
		this.qq = qq;
		this.beizhu = beizhu;
	}

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

}
