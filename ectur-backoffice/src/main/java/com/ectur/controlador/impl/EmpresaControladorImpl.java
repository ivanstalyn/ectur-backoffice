package com.ectur.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.controlador.EmpresaControlador;
import com.ectur.modelo.dao.EmpresaDao;
import com.ectur.modelo.dao.impl.EmpresaDaoImpl;
import com.ectur.modelo.entidad.Empresa;

public class EmpresaControladorImpl implements EmpresaControlador {
	
	private EmpresaDao EmpresaDao = new EmpresaDaoImpl();

	@Override
	public void insertar(Empresa nuevo) {
		EmpresaDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Empresa actual) {
		EmpresaDao.actualizar(actual);

	}

	@Override
	public void eliminar(Empresa eliminado) {
		EmpresaDao.eliminar(eliminado);

	}

	@Override
	public List<Empresa> listar() {
		return EmpresaDao.listar();
	}

	@Override
	public Empresa porId(int id) {
		return EmpresaDao.porId(id);
	}
	
	@Override
	public Empresa buscarPorId(int id) {
		return EmpresaDao.buscaPorId(id);
	}
	
	@Override
	public List<Empresa> buscarPorNombre(String nombre) {
		return EmpresaDao.porNombre(nombre);
	}
	
	@Override
	public List<Tuple> listarNombres(){
		return EmpresaDao.listarNombres();
	}

}
