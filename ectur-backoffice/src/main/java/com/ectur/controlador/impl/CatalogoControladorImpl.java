package com.ectur.controlador.impl;

import java.util.List;

import com.ectur.controlador.CatalogoControlador;
import com.ectur.modelo.dao.CatalogoDao;
import com.ectur.modelo.dao.impl.CatalogoDaoImpl;
import com.ectur.modelo.entidad.Catalogo;

public class CatalogoControladorImpl implements CatalogoControlador {
	
	private CatalogoDao catalogoDao = new CatalogoDaoImpl();

	@Override
	public void insertar(Catalogo nuevo) {
		catalogoDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Catalogo actual) {
		catalogoDao.actualizar(actual);

	}

	@Override
	public void eliminar(Catalogo eliminado) {
		catalogoDao.eliminar(eliminado);

	}

	@Override
	public List<Catalogo> listar() {
		return catalogoDao.listar();
	}

	@Override
	public Catalogo buscarPorId(int id) {
		return catalogoDao.buscarPorId(id);
	}
	
}
