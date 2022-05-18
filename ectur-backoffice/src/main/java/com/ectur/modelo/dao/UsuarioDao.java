package com.ectur.modelo.dao;

import java.util.List;

import com.ectur.modelo.entidad.Usuario;

public interface UsuarioDao {
	public void insertar(Usuario nuevo);
	public void actualizar(Usuario actual);
	public void eliminar(Usuario eliminado);
	public Usuario buscarPorId(int id);
	public Usuario buscarPorUsername(String username);
	public List<Usuario> listar();
	
}
