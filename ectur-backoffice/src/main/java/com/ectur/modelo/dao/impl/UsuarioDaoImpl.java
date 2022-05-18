package com.ectur.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ectur.modelo.dao.UsuarioDao;
import com.ectur.modelo.entidad.Usuario;

public class UsuarioDaoImpl extends GenericaDaoImpl<Usuario> implements UsuarioDao {

	@Override
	public void insertar(Usuario nuevo) {
		this.beginTransaction();
		this.create(nuevo);
		this.commit();
	}

	@Override
	public void actualizar(Usuario actual) {
		this.beginTransaction();
		this.update(actual);
		this.commit();
	}

	@Override
	public void eliminar(Usuario eliminado) {
		this.beginTransaction();
		this.delete(eliminado);
		this.commit();
	}

	@Override
	public List<Usuario> listar() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> cqUsuario = cb.createQuery(Usuario.class);
		Root<Usuario> tabla = cqUsuario.from(Usuario.class); 
		cqUsuario.select(tabla);
		return this.entityManager.createQuery(cqUsuario).getResultList();				

	}
	
	@Override
	public Usuario buscarPorId(int id) {

		return this.readClass(id, Usuario.class);
		
	}
	
	@Override
	public Usuario buscarPorUsername(String username) {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> cqUsuario = cb.createQuery(Usuario.class);
		Root<Usuario> tabla = cqUsuario.from(Usuario.class); 		
		cqUsuario.select(tabla).where(cb.equal(tabla.<String>get("username"), username ));
		return this.entityManager.createQuery(cqUsuario).getSingleResult();
		
	}

}
