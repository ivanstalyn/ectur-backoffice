package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.EmpresaDao;
import com.ectur.modelo.entidad.Empresa;

public class EmpresaDaoImpl extends GenericaDaoImpl<Empresa> implements EmpresaDao {

	@Override
	public void insertar(Empresa nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Empresa actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();
	}

	@Override
	public void eliminar(Empresa eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();
	}

	@Override
	public List<Empresa> listar() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empresa> cqEmpresa = cb.createQuery(Empresa.class);
		Root<Empresa> tabla = cqEmpresa.from(Empresa.class); 
		cqEmpresa.select(tabla);
		return this.entityManager.createQuery(cqEmpresa).getResultList();				

	}
	
	@Override
	public Empresa buscarPorId(int id) {

		return this.readClass(id, Empresa.class);
		
	}

}
