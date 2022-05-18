package com.ectur.modelo.dao;

import java.util.List;

import com.ectur.modelo.entidad.Empresa;

public interface EmpresaDao {
	public void insertar(Empresa nuevo);
	public void actualizar(Empresa actual);
	public void eliminar(Empresa eliminado);
	public Empresa buscarPorId(int id);
	public List<Empresa> listar();
	
}
