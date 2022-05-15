package com.ectur.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Propietario;

public interface PropietarioControlador {
	

	public void insertar(Propietario nuevo);
	public void actualizar(Propietario actual);
	public void eliminar(Propietario eliminado);
	public List<Propietario> listar();
	public Propietario buscarPorCelular(String celular);
	public Propietario buscarPorCedula(String cedula);
	public List<Propietario> buscarPorNombre(String nombre);
	public Propietario buscarPorId(int id);
	public List<Tuple> listarNombres();
	

}

