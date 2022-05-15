package com.ectur.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Empleado;

public interface EmpleadoControlador {
	
	public void insertar(Empleado nuevo);
	public void actualizar(Empleado actual);
	public void eliminar(Empleado eliminado);
	public List<Empleado> listar();
	public Empleado buscarPorId(int id);
	public List<Empleado> buscarPorNombre(String nombre);
	public Empleado buscarPorCedula(String cedula);
	public List<Tuple> listarNombres();
	public List<Empleado> listarTQ();

}
