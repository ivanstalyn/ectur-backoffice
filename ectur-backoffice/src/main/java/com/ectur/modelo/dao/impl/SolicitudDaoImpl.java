package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.SolicitudDao;
import com.ectur.modelo.entidad.Catalogo;
import com.ectur.modelo.entidad.Solicitud;
import com.ectur.modelo.entidad.Solicitud;
import com.ectur.modelo.entidad.Usuario;

public class SolicitudDaoImpl extends GenericaDaoImpl<Solicitud> implements SolicitudDao {

	@Override
	public void insertar(Solicitud nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Solicitud actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();
	}

	@Override
	public void eliminar(Solicitud eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();
	}

	@Override
	public List<Solicitud> listar() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Solicitud> cqSolicitud = cb.createQuery(Solicitud.class);
		Root<Solicitud> tabla = cqSolicitud.from(Solicitud.class); 
		cqSolicitud.select(tabla);
		return this.entityManager.createQuery(cqSolicitud).getResultList();				

	}
	
	@Override
	public Solicitud buscarPorId(int id) {

		return this.readClass(id, Solicitud.class);
		
	}
	
	@Override
	public List<Solicitud> buscarPorUsuario(Usuario usuario) {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Solicitud> cqSolicitud = cb.createQuery(Solicitud.class);
		Root<Solicitud> tabla = cqSolicitud.from(Solicitud.class); 		
		cqSolicitud.select(tabla).where(cb.equal(tabla.<String>get("usuario"),usuario));
		return this.entityManager.createQuery(cqSolicitud).getResultList();

	}

}
