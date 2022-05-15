package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.RazaDao;
import com.ectur.modelo.entidad.Raza;

public class RazaDaoImpl extends GenericaDaoImpl<Raza> implements RazaDao {

	@Override
	public void insertar(Raza nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();

	}

	@Override
	public void actualizar(Raza actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();

	}

	@Override
	public void eliminar(Raza eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();

	}

	@Override
	public List<Raza> listar() {

		// select * from raza
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Raza> cqRaza = cb.createQuery(Raza.class);
		Root<Raza> tabla = cqRaza.from(Raza.class); // from raza
		cqRaza.select(tabla);// select *
		return this.entityManager.createQuery(cqRaza).getResultList();
				

	}
	
	@Override
	public Raza porId(int id) {

		// select * from raza
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Raza> cqRaza = cb.createQuery(Raza.class);
		Root<Raza> tabla = cqRaza.from(Raza.class); // from raza
		cqRaza.select(tabla).where(cb.equal(tabla.get("id"), id));// select * where id = ?
		return this.entityManager.createQuery(cqRaza).getSingleResult();
		
	}
	@Override
	public Raza buscaPorId(int id) {

		return this.readClass(id, Raza.class);
		
	}
	
	public List<Raza> porNombre(String nombre) {

		// select * from raza
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Raza> cqRaza = cb.createQuery(Raza.class);
		Root<Raza> tabla = cqRaza.from(Raza.class); // from raza		
		cqRaza.select(tabla).where(cb.like(tabla.<String>get("nombre"), nombre + '%'));// select * where nombre like ?
		return this.entityManager.createQuery(cqRaza).getResultList();
		
	}
	
	public List<Tuple> listarNombres(){
		
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cqRaza = cb.createTupleQuery();
		Root<Raza> tabla = cqRaza.from(Raza.class); // from raza		
		cqRaza.select(cb.tuple(tabla.<String>get("nombre")));
		return this.entityManager.createQuery(cqRaza).getResultList();
		
	}

}
