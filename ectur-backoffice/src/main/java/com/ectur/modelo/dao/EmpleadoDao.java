package com.ectur.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Empleado;

public interface EmpleadoDao {
	public void insertar(Empleado nuevo);
	public void actualizar(Empleado actual);
	public void eliminar(Empleado eliminado);
	public List<Empleado> listar();
	public Empleado porId(int id);
	public List<Empleado> porNombre(String nombre);
	public Empleado porCedula(String cedula);
	public List<Tuple> listarNombres();
	public List<Empleado> listarTQ();

}
