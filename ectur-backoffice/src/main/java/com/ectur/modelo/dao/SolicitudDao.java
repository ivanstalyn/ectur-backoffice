package com.ectur.modelo.dao;

import java.util.List;

import com.ectur.modelo.entidad.Solicitud;
import com.ectur.modelo.entidad.Usuario;

public interface SolicitudDao {
	public void insertar(Solicitud nuevo);
	public void actualizar(Solicitud actual);
	public void eliminar(Solicitud eliminado);
	public Solicitud buscarPorId(int id);
	public List<Solicitud> buscarPorUsuario(Usuario usuario);
	public List<Solicitud> listar();
	
}
