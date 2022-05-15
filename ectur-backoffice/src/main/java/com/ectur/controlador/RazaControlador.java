package com.ectur.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Raza;

public interface RazaControlador {
	
	public void insertar(Raza nuevo);
	public void actualizar(Raza actual);
	public void eliminar(Raza eliminado);
	public List<Raza> listar();
	public Raza porId(int id);
	public Raza buscarPorId(int id);
	public List<Raza> buscarPorNombre(String nombre);
	public List<Tuple> listarNombres();

}
