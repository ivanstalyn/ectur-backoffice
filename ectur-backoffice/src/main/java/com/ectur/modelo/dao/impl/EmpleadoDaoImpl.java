package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.EmpleadoDao;
import com.ectur.modelo.entidad.Empleado;

public class EmpleadoDaoImpl extends GenericaDaoImpl<Empleado> implements EmpleadoDao {
	
	@Override
	public void insertar(Empleado nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Empleado actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();

	}

	@Override
	public void eliminar(Empleado eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();

	}

	@Override
	public List<Empleado> listar() {
		// select * from empleado
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado> cqEmpleado = cb.createQuery(Empleado.class);
		Root<Empleado> tabla = cqEmpleado.from(Empleado.class); // from empleado
		cqEmpleado.select(tabla);// select *
		return this.entityManager.createQuery(cqEmpleado).getResultList();
	}
	
	@Override
	public List<Empleado> listarTQ() {
		TypedQuery<Empleado> sqlTQ = this.entityManager.createQuery("Select emp from Empleado emp", Empleado.class);
		return sqlTQ.getResultList();
	}
	
	@Override
	public Empleado porId(int id) {

		// select * from empleado
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado> cqEmpleado = cb.createQuery(Empleado.class);
		Root<Empleado> tabla = cqEmpleado.from(Empleado.class); // from empleado
		cqEmpleado.select(tabla).where(cb.equal(tabla.get("id"), id));// select * where id = ?
		return this.entityManager.createQuery(cqEmpleado).getSingleResult();
		
	}
	
	@Override
	public List<Empleado> porNombre(String nombre) {

		// select * from empleado
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado> cqEmpleado = cb.createQuery(Empleado.class);
		Root<Empleado> tabla = cqEmpleado.from(Empleado.class); // from empleado		
		cqEmpleado.select(tabla).where(cb.like(tabla.<String>get("nombre"), nombre + '%'));// select * where nombre like ?
		return this.entityManager.createQuery(cqEmpleado).getResultList();
		
	}
	
	@Override
	public Empleado porCedula(String cedula) {

		// select * from empleado
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado> cqEmpleado = cb.createQuery(Empleado.class);
		Root<Empleado> tabla = cqEmpleado.from(Empleado.class); // from empleado		
		cqEmpleado.select(tabla).where(cb.equal(tabla.<String>get("cedula"), cedula ));// select * where cedula = ?
		return this.entityManager.createQuery(cqEmpleado).getSingleResult();
		
	}
	
	@Override
	public List<Tuple> listarNombres(){
		
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cqEmpleado = cb.createTupleQuery();
		Root<Empleado> tabla = cqEmpleado.from(Empleado.class); 		
		cqEmpleado.select(cb.tuple(tabla.<String>get("nombre")));
		return this.entityManager.createQuery(cqEmpleado).getResultList();
		
	}

}
