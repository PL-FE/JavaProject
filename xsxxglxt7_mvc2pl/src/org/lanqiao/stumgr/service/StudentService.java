package org.lanqiao.stumgr.service;

import java.io.Serializable;
import java.util.ArrayList;

import org.lanqiao.stumgr.bean.Student;
import org.lanqiao.stumgr.dao.StudentDao;

public class StudentService implements IBaseService<Student> {
	StudentDao studentDao = new StudentDao();

	@Override
	public boolean add(Student obj) {
		boolean ret = false;
		if (!studentDao.isExist(obj.getNo())) {
			ret = studentDao.add(obj);
		}
		return ret;
	}

	@Override
	public boolean deleteByNo(Serializable no) {
		return studentDao.deleteByNo(no);
	}

	@Override
	public boolean update(Student obj) {
		boolean ret = false;
		if (studentDao.isExist(obj.getNo())) {
			ret = studentDao.update(obj);
		}
		return ret;
	}

	

	@Override
	public ArrayList listAll() {
		// TODO Auto-generated method stub
		return studentDao.listAll();
	}

	public Student selectById(Serializable no) {
		return studentDao.findByNo(no);
	}
	
}
