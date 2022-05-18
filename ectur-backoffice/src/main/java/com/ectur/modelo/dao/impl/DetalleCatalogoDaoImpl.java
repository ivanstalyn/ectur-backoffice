package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.DetalleCatalogoDao;
import com.ectur.modelo.entidad.Catalogo;
import com.ectur.modelo.entidad.DetalleCatalogo;

public class DetalleCatalogoDaoImpl extends GenericaDaoImpl<DetalleCatalogo> implements DetalleCatalogoDao {

	@Override
	public void insertar(DetalleCatalogo nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(DetalleCatalogo actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();
	}

	@Override
	public void eliminar(DetalleCatalogo eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();
	}

	@Override
	public List<DetalleCatalogo> listar() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<DetalleCatalogo> cqDetalleCatalogo = cb.createQuery(DetalleCatalogo.class);
		Root<DetalleCatalogo> tabla = cqDetalleCatalogo.from(DetalleCatalogo.class); 
		cqDetalleCatalogo.select(tabla);
		return this.entityManager.createQuery(cqDetalleCatalogo).getResultList();				

	}
	
	@Override
	public DetalleCatalogo buscarPorId(int id) {

		return this.readClass(id, DetalleCatalogo.class);
		
	}

	@Override
	public List<DetalleCatalogo> buscarPorCatalogo(Catalogo catalogo) {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<DetalleCatalogo> cqDetalleCatalogo = cb.createQuery(DetalleCatalogo.class);
		Root<DetalleCatalogo> tabla = cqDetalleCatalogo.from(DetalleCatalogo.class); 		
		cqDetalleCatalogo.select(tabla).where(cb.equal(tabla.<String>get("catalogo"),catalogo));
		return this.entityManager.createQuery(cqDetalleCatalogo).getResultList();

	}

}
