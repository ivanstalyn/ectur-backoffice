package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.ProductoDao;
import com.ectur.modelo.entidad.Producto;

public class ProductoDaoImpl extends GenericaDaoImpl<Producto> implements ProductoDao {

	@Override
	public void insertar(Producto nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Producto actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();
	}

	@Override
	public void eliminar(Producto eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();
	}

	@Override
	public List<Producto> listar() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto> cqProducto = cb.createQuery(Producto.class);
		Root<Producto> tabla = cqProducto.from(Producto.class); 
		cqProducto.select(tabla);
		return this.entityManager.createQuery(cqProducto).getResultList();				

	}
	
	@Override
	public Producto buscarPorId(int id) {

		return this.readClass(id, Producto.class);
		
	}
}
