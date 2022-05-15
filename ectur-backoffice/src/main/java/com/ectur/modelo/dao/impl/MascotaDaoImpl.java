package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.MascotaDao;
import com.ectur.modelo.entidad.Mascota;
import com.ectur.modelo.entidad.Raza;

public class MascotaDaoImpl extends GenericaDaoImpl<Mascota>  implements MascotaDao {
	
	@Override
	public void insertar(Mascota nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Mascota actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();
	}

	@Override
	public void eliminar(Mascota eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();

	}

	@Override
	public List<Mascota> listar() {
		// select * from mascota
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Mascota> cqMascota = cb.createQuery(Mascota.class);
		Root<Mascota> tabla = cqMascota.from(Mascota.class); // from mascota
		cqMascota.select(tabla);// select *
		return this.entityManager.createQuery(cqMascota).getResultList();
	}
	
	@Override
	public List<Mascota> porNombre(String nombre) {

		// select * from mascota
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Mascota> cqMascota = cb.createQuery(Mascota.class);
		Root<Mascota> tabla = cqMascota.from(Mascota.class); // from mascota		
		cqMascota.select(tabla).where(cb.like(tabla.<String>get("nombre"), nombre + '%'));// select * where nombre like ?
		return this.entityManager.createQuery(cqMascota).getResultList();
		
	}
	
	@Override
	public List<Mascota> porRaza(Raza raza) {

		// select * from mascota
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Mascota> cqMascota = cb.createQuery(Mascota.class);
		Root<Mascota> tabla = cqMascota.from(Mascota.class); // from mascota		
		cqMascota.select(tabla).where(cb.equal(tabla.<String>get("raza"),raza));
		return this.entityManager.createQuery(cqMascota).getResultList();
		
	}

	@Override
	public List<Tuple> listarDatosBasicos() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cqMascota = cb.createTupleQuery();
		Root<Mascota> tabla = cqMascota.from(Mascota.class); 		
		cqMascota.select(cb.tuple(tabla.<String>get("nombre"),tabla.<String>get("sexo")));
		return this.entityManager.createQuery(cqMascota).getResultList();
	}
	
	@Override
	public Mascota buscaPorId(int id) {

		return this.readClass(id, Mascota.class);
		
	}

}
