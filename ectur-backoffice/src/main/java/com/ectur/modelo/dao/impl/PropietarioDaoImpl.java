package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.PropietarioDao;
import com.ectur.modelo.entidad.Propietario;

public class PropietarioDaoImpl extends GenericaDaoImpl<Propietario> implements PropietarioDao {
	

	@Override
	public void insertar(Propietario nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Propietario actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();


	}

	@Override
	public void eliminar(Propietario eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();

	}

	@Override
	public List<Propietario> listar() {
		// select * from Propietario
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Propietario> cqPropietario = cb.createQuery(Propietario.class);
		Root<Propietario> tabla = cqPropietario.from(Propietario.class); // from propietario
		cqPropietario.select(tabla);// select *
		return this.entityManager.createQuery(cqPropietario).getResultList();
	}
	
	@Override
	public Propietario porId(int id) {

		// select * from propietario
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Propietario> cqPropietario = cb.createQuery(Propietario.class);
		Root<Propietario> tabla = cqPropietario.from(Propietario.class); // from propietario
		cqPropietario.select(tabla).where(cb.equal(tabla.get("id"), id));// select * where id = ?
		return this.entityManager.createQuery(cqPropietario).getSingleResult();
		
	}
	
	@Override
	public List<Propietario> porNombre(String nombre) {

		// select * from propietario
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Propietario> cqPropietario = cb.createQuery(Propietario.class);
		Root<Propietario> tabla = cqPropietario.from(Propietario.class); // from propietario		
		cqPropietario.select(tabla).where(cb.like(tabla.<String>get("nombre"), nombre + '%'));// select * where nombre like ?
		return this.entityManager.createQuery(cqPropietario).getResultList();
		
	}
	
	@Override
	public Propietario porCedula(String cedula) {

		// select * from propietario
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Propietario> cqPropietario = cb.createQuery(Propietario.class);
		Root<Propietario> tabla = cqPropietario.from(Propietario.class); // from propietario		
		cqPropietario.select(tabla).where(cb.equal(tabla.<String>get("cedula"), cedula ));// select * where cedula = ?
		return this.entityManager.createQuery(cqPropietario).getSingleResult();
		
	}
	
	@Override
	public Propietario porCelular(String celular) {

		// select * from propietario
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Propietario> cqPropietario = cb.createQuery(Propietario.class);
		Root<Propietario> tabla = cqPropietario.from(Propietario.class); // from propietario		
		cqPropietario.select(tabla).where(cb.equal(tabla.<String>get("celular"), celular ));// select * where celular = ?
		return this.entityManager.createQuery(cqPropietario).getSingleResult();
		
	}
	
	@Override
	public List<Tuple> listarNombres(){
		
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cqPropietario = cb.createTupleQuery();
		Root<Propietario> tabla = cqPropietario.from(Propietario.class); 		
		cqPropietario.select(cb.tuple(tabla.<String>get("nombre")));
		return this.entityManager.createQuery(cqPropietario).getResultList();
		
	}

	
}
