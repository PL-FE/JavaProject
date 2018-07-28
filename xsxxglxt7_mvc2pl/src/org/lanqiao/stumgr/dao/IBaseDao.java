package org.lanqiao.stumgr.dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface IBaseDao<E> {
	boolean add(E obj); 
	
	boolean deleteByNo(Serializable no); 
	
	boolean update(E obj); 
	
	E findByNo(Serializable no); 
	
	ArrayList<E> listAll();
	
	
	boolean isExist(Serializable id);
}
