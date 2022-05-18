package com.ectur.modelo.dao;

import java.util.List;

import com.ectur.modelo.entidad.Catalogo;

public interface CatalogoDao {
	public void insertar(Catalogo nuevo);
	public void actualizar(Catalogo actual);
	public void eliminar(Catalogo eliminado);
	public Catalogo buscarPorId(int id);
	public List<Catalogo> listar();
	
}
