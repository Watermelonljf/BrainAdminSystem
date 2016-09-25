package com.adminsystem.Dao;

import java.util.List;

public interface DAO<T> {
	/**
	 * 功能:执行插入语句，成功返回true,否则false
	 * @param t 为泛型变量
	 * @return
	 */
	boolean Insert(T t);
	
	/**
	 * 功能:执行指定记录的删除功能，成功返回true，否则false
	 * @param id
	 * @return
	 */
	
	boolean delete(int id);
	
	/**
	 * 
	 * 功能:更新指定记录，成功返回true；否则false；
	 * @param id
	 * @return
	 */
	
	boolean update(int id);
	
	/**
	 * 功能：分页查询包含
	 * @param strWhere
	 * @param orderby
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	List<T> query(String strWhere, String orderby, int pageSize, int pageIndex);
}
