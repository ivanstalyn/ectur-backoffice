package com.ectur.controlador;

import java.util.List;

import com.ectur.modelo.entidad.Catalogo;

public interface CatalogoControlador {
	
	public void insertar(Catalogo nuevo);
	public void actualizar(Catalogo actual);
	public void eliminar(Catalogo eliminado);
	public List<Catalogo> listar();
	public Catalogo buscarPorId(int id);
}
