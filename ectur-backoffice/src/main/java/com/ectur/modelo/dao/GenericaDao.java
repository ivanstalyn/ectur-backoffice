package com.ectur.modelo.dao;

import java.util.List;

public interface GenericaDao <T> {

	public T create(T t);
	public T read(Object id);
	public T readClass(Object id, Class<T> entityClass);
	public void delete(T t);
	public T update(T t);
	public List<T> findAll();
	public void flush();
	public void commitAndCloseTransaction();
	public void closeTransaction();
	public void rollback();
	public void commit();
	public void beginTransaction();


}
