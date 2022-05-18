package com.ectur.controlador;

import java.util.List;


import com.ectur.modelo.entidad.Usuario;

public interface UsuarioControlador {
	
	public void insertar(Usuario nuevo);
	public void actualizar(Usuario actual);
	public void eliminar(Usuario eliminado);
	public List<Usuario> listar();
	public Usuario buscarPorId(int id);
	public Usuario buscarPorUsername(String username);

}
