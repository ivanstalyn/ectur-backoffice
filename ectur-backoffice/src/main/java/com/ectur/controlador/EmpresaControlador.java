package com.ectur.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Empresa;

public interface EmpresaControlador {
	
	public void insertar(Empresa nuevo);
	public void actualizar(Empresa actual);
	public void eliminar(Empresa eliminado);
	public List<Empresa> listar();
	public Empresa porId(int id);
	public Empresa buscarPorId(int id);
	public List<Empresa> buscarPorNombre(String nombre);
	public List<Tuple> listarNombres();

}
