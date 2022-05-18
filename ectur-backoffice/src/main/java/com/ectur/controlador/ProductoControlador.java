package com.ectur.controlador;

import java.util.List;


import com.ectur.modelo.entidad.Producto;

public interface ProductoControlador {
	
	public void insertar(Producto nuevo);
	public void actualizar(Producto actual);
	public void eliminar(Producto eliminado);
	public List<Producto> listar();
	public Producto buscarPorId(int id);

}
