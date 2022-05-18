package com.ectur.controlador.impl;

import java.util.List;

import com.ectur.controlador.DetalleCatalogoControlador;
import com.ectur.modelo.dao.DetalleCatalogoDao;
import com.ectur.modelo.dao.impl.DetalleCatalogoDaoImpl;
import com.ectur.modelo.entidad.Catalogo;
import com.ectur.modelo.entidad.DetalleCatalogo;

public class DetalleCatalogoControladorImpl implements DetalleCatalogoControlador {
	
	private DetalleCatalogoDao detalleCatalogoDao = new DetalleCatalogoDaoImpl();

	@Override
	public void insertar(DetalleCatalogo nuevo) {
		detalleCatalogoDao.insertar(nuevo);

	}

	@Override
	public void actualizar(DetalleCatalogo actual) {
		detalleCatalogoDao.actualizar(actual);

	}

	@Override
	public void eliminar(DetalleCatalogo eliminado) {
		detalleCatalogoDao.eliminar(eliminado);

	}

	@Override
	public List<DetalleCatalogo> listar() {
		return detalleCatalogoDao.listar();
	}

	@Override
	public DetalleCatalogo buscarPorId(int id) {
		return detalleCatalogoDao.buscarPorId(id);
	}

	@Override
	public List<DetalleCatalogo> buscarPorCatalogo(Catalogo catalogo) {
		return detalleCatalogoDao.buscarPorCatalogo(catalogo);
	}
	
}
