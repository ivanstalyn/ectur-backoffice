package com.ectur.controlador.impl;

import java.util.List;

import com.ectur.controlador.EmpresaControlador;
import com.ectur.modelo.dao.EmpresaDao;
import com.ectur.modelo.dao.impl.EmpresaDaoImpl;
import com.ectur.modelo.entidad.Empresa;

public class EmpresaControladorImpl implements EmpresaControlador {
	
	private EmpresaDao empresaDao = new EmpresaDaoImpl();

	@Override
	public void insertar(Empresa nuevo) {
		empresaDao.insertar(nuevo);

	}

	@Override
	public void actualizar(Empresa actual) {
		empresaDao.actualizar(actual);

	}

	@Override
	public void eliminar(Empresa eliminado) {
		empresaDao.eliminar(eliminado);

	}

	@Override
	public List<Empresa> listar() {
		return empresaDao.listar();
	}

	@Override
	public Empresa buscarPorId(int id) {
		return empresaDao.buscarPorId(id);
	}
	
}
