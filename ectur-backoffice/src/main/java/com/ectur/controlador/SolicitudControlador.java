package com.ectur.controlador;

import java.util.List;


import com.ectur.modelo.entidad.Solicitud;

public interface SolicitudControlador {
	
	public void insertar(Solicitud nuevo);
	public void actualizar(Solicitud actual);
	public void eliminar(Solicitud eliminado);
	public List<Solicitud> listar();
	public Solicitud buscarPorId(int id);

}
