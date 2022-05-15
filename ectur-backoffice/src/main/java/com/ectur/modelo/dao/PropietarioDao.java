package com.ectur.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Propietario;

public interface PropietarioDao {

	public void insertar(Propietario nuevo);
	public void actualizar(Propietario actual);
	public void eliminar(Propietario eliminado);
	public List<Propietario> listar();
	public Propietario porCedula(String cedula);
	public List<Propietario> porNombre(String nombre);
	public Propietario porId(int id);
	public Propietario porCelular(String celular);
	public List<Tuple> listarNombres();

}
