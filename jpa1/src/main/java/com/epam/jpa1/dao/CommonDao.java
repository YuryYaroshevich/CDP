package com.epam.jpa1.dao;

public interface CommonDao {
	Object create(Object entity);
	
	Object find(long id, Class<?> entityClass);
	
	void delete(long id, Class<?> entityClass);
	
	Object update(Object updatedEntity);
}
