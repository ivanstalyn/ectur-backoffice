package com.ectur.controlador.impl;

import java.util.List;

import com.ectur.controlador.SolicitudControlador;
import com.ectur.modelo.dao.SolicitudDao;
import com.ectur.modelo.dao.impl.SolicitudDaoImpl;
import com.ectur.modelo.entidad.Solicitud;

public class SolicitudControladorImpl implements SolicitudControlador {
	
	private SolicitudDao solicitudDao = new SolicitudDaoImpl();

	@Override
	public void insertar(Solicitud nuevo) {
		solicitudDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Solicitud actual) {
		solicitudDao.actualizar(actual);

	}

	@Override
	public void eliminar(Solicitud eliminado) {
		solicitudDao.eliminar(eliminado);

	}

	@Override
	public List<Solicitud> listar() {
		return solicitudDao.listar();
	}

	@Override
	public Solicitud buscarPorId(int id) {
		return solicitudDao.buscarPorId(id);
	}

	
	
}
