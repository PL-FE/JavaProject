package org.lanqiao.stumgr.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.stumgr.bean.Student;
import org.lanqiao.stumgr.common.DatabaseCrud;
import org.lanqiao.stumgr.common.JdbcCommon;

public class StudentDao implements IBaseDao<Student>{
static Student stu = null ;
	@Override
	public boolean add(Student obj) {
		String sql = "insert into Student(no,name,idCard,sex,age) values(?,?,?,?,?)";
		Object values[] = {obj.getNo(),obj.getName(),obj.getIdCard(),obj.getSex(),obj.getAge()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	@Override
	public boolean deleteByNo(Serializable no) {
		String sql = "delete from Student where no = ?";
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, no);		
		return ret;
	}

	@Override
	public boolean update(Student obj) {
		String sql = "update Student set name = ?,idCard = ?,sex = ?,age = ? where no = ?";
		Object values[] = {obj.getName(),obj.getIdCard(),obj.getSex(),obj.getAge(),obj.getNo()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	@Override
	public Student findByNo(Serializable no) {
		String sql = "select no,name,idcard,sex,age from Student";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, no);
			if (null != rs && rs.next()) {
				stu = new Student(rs.getString("no"),rs.getString("name"),rs.getString("idCard"),rs.getInt("sex"),rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public ArrayList<Student> listAll() {
		ArrayList<Student> ls = new ArrayList<>();
		String sql = "select no,name,idcard,sex,age from Student";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			if(null != rs ){
				while ( rs.next()) {
				stu = new Student(rs.getString("no"),rs.getString("name"),rs.getString("idCard"),rs.getInt("sex"),rs.getInt("age"));
				ls.add(stu);
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public boolean isExist(Serializable id) {
		boolean ret = false;
		try {
			String sql = "select 1 from student where no = ? ";
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql,id);
			ret = rs != null && rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	
	}

	

}
