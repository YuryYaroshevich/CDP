package com.epam.jpa1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDaoImpl implements CommonDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Object create(Object entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			entityManager.persist(entity);
			return entity;	
		} finally {
			tx.commit();
			entityManager.close();
		}
	}
	
	@Override
	public Object find(long id, Class<?> entityClass) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Object entity = entityManager.find(entityClass, Long.valueOf(id));
			return entity;	
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public void delete(long id, Class<?> entityClass) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			Object entity = entityManager.find(entityClass, Long.valueOf(id));
			entityManager.remove(entity);	
		} finally {
			tx.commit();
			entityManager.close();
		}
	}
	
	@Override
	public Object update(Object updatedEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			return entityManager.merge(updatedEntity);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			entityManager.close();
		}
	}
}
