package com.ectur.controlador.impl;

import java.util.List;

import com.ectur.controlador.ProductoControlador;
import com.ectur.modelo.dao.ProductoDao;
import com.ectur.modelo.dao.impl.ProductoDaoImpl;
import com.ectur.modelo.entidad.Producto;

public class ProductoControladorImpl implements ProductoControlador {
	
	private ProductoDao productoDao = new ProductoDaoImpl();

	@Override
	public void insertar(Producto nuevo) {
		productoDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Producto actual) {
		productoDao.actualizar(actual);

	}

	@Override
	public void eliminar(Producto eliminado) {
		productoDao.eliminar(eliminado);

	}

	@Override
	public List<Producto> listar() {
		return productoDao.listar();
	}

	@Override
	public Producto buscarPorId(int id) {
		return productoDao.buscarPorId(id);
	}

	
	
}
