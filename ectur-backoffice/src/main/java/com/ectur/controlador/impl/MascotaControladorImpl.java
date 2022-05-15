package com.ectur.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.controlador.MascotaControlador;
import com.ectur.modelo.dao.MascotaDao;
import com.ectur.modelo.dao.impl.MascotaDaoImpl;
import com.ectur.modelo.entidad.Mascota;
import com.ectur.modelo.entidad.Raza;

public class MascotaControladorImpl implements MascotaControlador{
	
	private MascotaDao mascotaDao = new MascotaDaoImpl();

	@Override
	public void insertar(Mascota nuevo) {
		mascotaDao.insertar(nuevo);
		
	}

	@Override
	public void actualizar(Mascota actual) {
		mascotaDao.actualizar(actual);
		
	}

	@Override
	public void eliminar(Mascota eliminado) {
		mascotaDao.eliminar(eliminado);
		
	}

	@Override
	public List<Mascota> listar() {
		
		return mascotaDao.listar();
	}

	@Override
	public List<Mascota> buscarPorNombre(String nombre) {
		
		return mascotaDao.porNombre(nombre);
	}

	@Override
	public List<Mascota> buscarPorRaza(Raza raza) {
		
		return mascotaDao.porRaza(raza);
	}

	@Override
	public List<Tuple> listarDatosBasicos() {
		return mascotaDao.listarDatosBasicos();
	}
	
	@Override
	public Mascota buscarPorId(int id) {
		return mascotaDao.buscaPorId(id);
	}

}
