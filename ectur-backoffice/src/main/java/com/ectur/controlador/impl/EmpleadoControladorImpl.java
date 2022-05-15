package com.ectur.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.controlador.EmpleadoControlador;
import com.ectur.modelo.dao.EmpleadoDao;
import com.ectur.modelo.dao.impl.EmpleadoDaoImpl;
import com.ectur.modelo.entidad.Empleado;

public class EmpleadoControladorImpl implements EmpleadoControlador {
	
	private EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

	@Override
	public void insertar(Empleado nuevo) {
		empleadoDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Empleado actual) {
		empleadoDao.actualizar(actual);

	}

	@Override
	public void eliminar(Empleado eliminado) {
		empleadoDao.eliminar(eliminado);

	}

	@Override
	public List<Empleado> listar() {
		
		return empleadoDao.listar();
	}
	
	@Override
	public List<Empleado> listarTQ() {
		return empleadoDao.listarTQ();
	}

	@Override
	public Empleado buscarPorId(int id) {
		
		return empleadoDao.porId(id);
	}

	@Override
	public List<Empleado> buscarPorNombre(String nombre) {
		
		return empleadoDao.porNombre(nombre);
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {

		return empleadoDao.porCedula(cedula);
	}

	@Override
	public List<Tuple> listarNombres() {
		return empleadoDao.listarNombres();
	}

}
