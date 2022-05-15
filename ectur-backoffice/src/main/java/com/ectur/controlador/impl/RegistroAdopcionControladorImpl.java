package com.ectur.controlador.impl;

import java.util.List;

import com.ectur.controlador.RegistroAdopcionControlador;
import com.ectur.modelo.dao.RegistroAdopcionDao;
import com.ectur.modelo.dao.impl.RegistroAdopcionDaoImpl;
import com.ectur.modelo.entidad.Empleado;
import com.ectur.modelo.entidad.Propietario;
import com.ectur.modelo.entidad.Raza;
import com.ectur.modelo.entidad.RegistroAdopcion;

public class RegistroAdopcionControladorImpl implements RegistroAdopcionControlador {
	
	private RegistroAdopcionDao regAdopDao = new RegistroAdopcionDaoImpl();
	

	@Override
	public void insertar(RegistroAdopcion nuevo) {
		regAdopDao.insertar(nuevo);

	}

	@Override
	public void actualizar(RegistroAdopcion actual) {
		regAdopDao.actualizar(actual);

	}

	@Override
	public void eliminar(RegistroAdopcion eliminado) {
		regAdopDao.eliminar(eliminado);

	}

	@Override
	public List<RegistroAdopcion> listar() {
		
		return regAdopDao.listar();
	}

	@Override
	public List<RegistroAdopcion> buscarPorRaza(Raza raza) {
		
		return regAdopDao.porRaza(raza);
	}

	@Override
	public List<RegistroAdopcion> buscarPorPropietario(Propietario propietario) {

		return regAdopDao.porPropietario(propietario);
	}

	@Override
	public List<RegistroAdopcion> buscarPorEmpleado(Empleado empleado) {

		return regAdopDao.porEmpleado(empleado);
	}

}
