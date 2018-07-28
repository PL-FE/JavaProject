package org.lanqiao.stumgr.service;

import java.io.Serializable;
import java.util.ArrayList;

public interface IBaseService<E> {
	boolean add(E obj); 
	
	boolean deleteByNo(Serializable no); 
	
	boolean update(E obj); 
	
	
	
	ArrayList<E> listAll();
}
