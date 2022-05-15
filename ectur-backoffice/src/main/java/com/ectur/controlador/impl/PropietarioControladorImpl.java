package com.ectur.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.controlador.PropietarioControlador;
import com.ectur.modelo.dao.PropietarioDao;
import com.ectur.modelo.dao.impl.PropietarioDaoImpl;
import com.ectur.modelo.entidad.Propietario;

public class PropietarioControladorImpl implements PropietarioControlador {
	
	PropietarioDao propietarioDao = new PropietarioDaoImpl();

	@Override
	public void insertar(Propietario nuevo) {
		propietarioDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Propietario actual) {
		propietarioDao.actualizar(actual);

	}

	@Override
	public void eliminar(Propietario eliminado) {
		propietarioDao.eliminar(eliminado);

	}

	@Override
	public List<Propietario> listar() {

		return propietarioDao.listar();
	}
	
	@Override
	public Propietario buscarPorId(int id) {
		
		return propietarioDao.porId(id);
	}

	@Override
	public List<Propietario> buscarPorNombre(String nombre) {
		
		return propietarioDao.porNombre(nombre);
	}

	@Override
	public Propietario buscarPorCedula(String cedula) {

		return propietarioDao.porCedula(cedula);
	}
	
	@Override
	public Propietario buscarPorCelular(String celular) {

		return propietarioDao.porCelular(celular);
	}

	@Override
	public List<Tuple> listarNombres() {
		return propietarioDao.listarNombres();
	}

	
}
