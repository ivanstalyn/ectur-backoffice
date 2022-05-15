package com.ectur.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.controlador.RazaControlador;
import com.ectur.modelo.dao.RazaDao;
import com.ectur.modelo.dao.impl.RazaDaoImpl;
import com.ectur.modelo.entidad.Raza;

public class RazaControladorImpl implements RazaControlador {
	
	private RazaDao razaDao = new RazaDaoImpl();

	@Override
	public void insertar(Raza nuevo) {
		razaDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Raza actual) {
		razaDao.actualizar(actual);

	}

	@Override
	public void eliminar(Raza eliminado) {
		razaDao.eliminar(eliminado);

	}

	@Override
	public List<Raza> listar() {
		return razaDao.listar();
	}

	@Override
	public Raza porId(int id) {
		return razaDao.porId(id);
	}
	
	@Override
	public Raza buscarPorId(int id) {
		return razaDao.buscaPorId(id);
	}
	
	@Override
	public List<Raza> buscarPorNombre(String nombre) {
		return razaDao.porNombre(nombre);
	}
	
	@Override
	public List<Tuple> listarNombres(){
		return razaDao.listarNombres();
	}

}
