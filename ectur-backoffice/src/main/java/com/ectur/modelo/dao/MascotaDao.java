package com.ectur.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Mascota;
import com.ectur.modelo.entidad.Raza;

public interface MascotaDao {
	
	public void insertar(Mascota nuevo);
	public void actualizar(Mascota actual);
	public void eliminar(Mascota eliminado);
	public List<Mascota> listar();
	public List<Mascota> porNombre(String nombre);
	public List<Mascota> porRaza(Raza raza);
	public List<Tuple> listarDatosBasicos();
	public Mascota buscaPorId(int id);

}
