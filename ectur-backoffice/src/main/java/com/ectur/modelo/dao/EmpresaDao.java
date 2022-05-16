package com.ectur.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Empresa;

public interface EmpresaDao {
	public void insertar(Empresa nuevo);
	public void actualizar(Empresa actual);
	public void eliminar(Empresa eliminado);
	public Empresa porId(int id);
	public Empresa buscaPorId(int id);
	public List<Empresa> listar();
	public List<Empresa> porNombre(String nombre);
	public List<Tuple> listarNombres();
	
}
