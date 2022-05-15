package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.RegistroAdopcionDao;
import com.ectur.modelo.entidad.RegistroAdopcion;
import com.ectur.modelo.entidad.Empleado;
import com.ectur.modelo.entidad.Propietario;
import com.ectur.modelo.entidad.Raza;

public class RegistroAdopcionDaoImpl extends GenericaDaoImpl<RegistroAdopcion> implements RegistroAdopcionDao {

	@Override
	public void insertar(RegistroAdopcion nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(RegistroAdopcion actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();

	}

	@Override
	public void eliminar(RegistroAdopcion eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();


	}

	@Override
	public List<RegistroAdopcion> listar() {
		// select * from RegistroAdopcion
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RegistroAdopcion> cqRegistroAdopcion = cb.createQuery(RegistroAdopcion.class);
		Root<RegistroAdopcion> tabla = cqRegistroAdopcion.from(RegistroAdopcion.class); // from RegistroAdopcion
		cqRegistroAdopcion.select(tabla);// select *
		return this.entityManager.createQuery(cqRegistroAdopcion).getResultList();
	}
	
	@Override
	public List<RegistroAdopcion> porRaza(Raza raza) {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RegistroAdopcion> cqRegistroAdopcion = cb.createQuery(RegistroAdopcion.class);
		Root<RegistroAdopcion> tabla = cqRegistroAdopcion.from(RegistroAdopcion.class); 		
		cqRegistroAdopcion.select(tabla).where(cb.equal(tabla.<String>get("mascota").get("raza"),raza));
		return this.entityManager.createQuery(cqRegistroAdopcion).getResultList();
		
	}

	@Override
	public List<RegistroAdopcion> porPropietario(Propietario propietario) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RegistroAdopcion> cqRegistroAdopcion = cb.createQuery(RegistroAdopcion.class);
		Root<RegistroAdopcion> tabla = cqRegistroAdopcion.from(RegistroAdopcion.class); 		
		cqRegistroAdopcion.select(tabla).where(cb.equal(tabla.<String>get("propietario"),propietario));
		return this.entityManager.createQuery(cqRegistroAdopcion).getResultList();
	}

	@Override
	public List<RegistroAdopcion> porEmpleado(Empleado empleado) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RegistroAdopcion> cqRegistroAdopcion = cb.createQuery(RegistroAdopcion.class);
		Root<RegistroAdopcion> tabla = cqRegistroAdopcion.from(RegistroAdopcion.class); 		
		cqRegistroAdopcion.select(tabla).where(cb.equal(tabla.<String>get("empleado"),empleado));
		return this.entityManager.createQuery(cqRegistroAdopcion).getResultList();
	}

}
