package com.ectur.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.ectur.modelo.entidad.Mascota;
import com.ectur.modelo.entidad.Raza;

public interface MascotaControlador {
	
	public void insertar(Mascota nuevo);
	public void actualizar(Mascota actual);
	public void eliminar(Mascota eliminado);
	public List<Mascota> listar();
	public List<Mascota> buscarPorNombre(String nombre);
	public List<Mascota> buscarPorRaza(Raza raza);
	public List<Tuple> listarDatosBasicos();
	public Mascota buscarPorId(int id);

}
