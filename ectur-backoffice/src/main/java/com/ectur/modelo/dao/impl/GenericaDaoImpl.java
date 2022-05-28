package com.ectur.modelo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import com.ectur.modelo.dao.GenericaDao;

public class GenericaDaoImpl<T> implements GenericaDao<T> {

	private Class<T> entityClass;
	
	protected static EntityManagerFactory emf = null;
	protected EntityManager entityManager;

	// constructores
	public GenericaDaoImpl() {
		emf = Persistence.createEntityManagerFactory("PUecturbackoffice",getPropiedades());
		entityManager = emf.createEntityManager();
		
	}


	public GenericaDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
		emf = Persistence.createEntityManagerFactory("PUecturbackoffice",getPropiedades());
		entityManager = emf.createEntityManager();
	}
	
	private Map<String, String> getPropiedades(){
		
		Map<String, String> propiedades = new HashMap<String, String>();
		
		
			propiedades.put("javax.persistence.jdbc.driver", System.getenv("JPA_DRIVER"));
			propiedades.put("javax.persistence.jdbc.url", System.getenv("JPA_URL"));
			propiedades.put("javax.persistence.jdbc.user", System.getenv("JPA_USUARIO"));
			propiedades.put("javax.persistence.jdbc.password", System.getenv("JPA_PASSWORD"));

		propiedades.put("javax.persistence.schema-generation.database.action", "create");
		return propiedades;
	}

	
	// Definimos el CRUD
	@Override
	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	@Override
	public T read(Object id) {
		return this.entityManager.find(entityClass, id);
	}
	
	@Override
	public T readClass(Object id, Class<T> entityClass) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

	// Definir los parámetros
	@Override
	public void beginTransaction() {
		if (!entityManager.getTransaction().isActive()) //existe conexion activa
			entityManager = emf.createEntityManager(); //crear conexion

		entityManager.getTransaction().begin(); //inicializar transacción
	}

	@Override
	public void commit() {
		if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().commit();
	}

	@Override
	public void rollback() {
		if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().rollback();
	}

	@Override
	public void closeTransaction() {
		entityManager.close();
	}

	@Override
	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return this.entityManager.createQuery(cq).getResultList();
	}
}