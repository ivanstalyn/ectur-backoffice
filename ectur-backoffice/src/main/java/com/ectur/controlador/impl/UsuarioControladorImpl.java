package com.ectur.controlador.impl;

import java.util.List;

import com.ectur.controlador.UsuarioControlador;
import com.ectur.modelo.dao.UsuarioDao;
import com.ectur.modelo.dao.impl.UsuarioDaoImpl;
import com.ectur.modelo.entidad.Catalogo;
import com.ectur.modelo.entidad.Usuario;

public class UsuarioControladorImpl implements UsuarioControlador {
	
	private UsuarioDao usuarioDao = new UsuarioDaoImpl();

	@Override
	public void insertar(Usuario nuevo) {
		usuarioDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Usuario actual) {
		usuarioDao.actualizar(actual);

	}

	@Override
	public void eliminar(Usuario eliminado) {
		usuarioDao.eliminar(eliminado);

	}

	@Override
	public List<Usuario> listar() {
		return usuarioDao.listar();
	}

	@Override
	public Usuario buscarPorId(int id) {
		return usuarioDao.buscarPorId(id);
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return usuarioDao.buscarPorUsername(username);
	}
	
}
