package com.ectur.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Raza;

public interface RazaDao {
	public void insertar(Raza nuevo);
	public void actualizar(Raza actual);
	public void eliminar(Raza eliminado);
	public Raza porId(int id);
	public Raza buscaPorId(int id);
	public List<Raza> listar();
	public List<Raza> porNombre(String nombre);
	public List<Tuple> listarNombres();
	
}
