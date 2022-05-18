package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.CatalogoDao;
import com.ectur.modelo.entidad.Catalogo;

public class CatalogoDaoImpl extends GenericaDaoImpl<Catalogo> implements CatalogoDao {

	@Override
	public void insertar(Catalogo nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Catalogo actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();
	}

	@Override
	public void eliminar(Catalogo eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();
	}

	@Override
	public List<Catalogo> listar() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Catalogo> cqCatalogo = cb.createQuery(Catalogo.class);
		Root<Catalogo> tabla = cqCatalogo.from(Catalogo.class); 
		cqCatalogo.select(tabla);
		return this.entityManager.createQuery(cqCatalogo).getResultList();				

	}
	
	@Override
	public Catalogo buscarPorId(int id) {

		return this.readClass(id, Catalogo.class);
		
	}

}
