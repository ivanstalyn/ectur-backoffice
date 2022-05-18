package com.ectur.modelo.dao;

import java.util.List;

import com.ectur.modelo.entidad.Producto;

public interface ProductoDao {
	public void insertar(Producto nuevo);
	public void actualizar(Producto actual);
	public void eliminar(Producto eliminado);
	public Producto buscarPorId(int id);
	public List<Producto> listar();
}
