package com.ectur.controlador;

import java.util.List;

import com.ectur.modelo.entidad.Empleado;
import com.ectur.modelo.entidad.Propietario;
import com.ectur.modelo.entidad.Raza;
import com.ectur.modelo.entidad.RegistroAdopcion;

public interface RegistroAdopcionControlador {
	
	public void insertar(RegistroAdopcion nuevo);
	public void actualizar(RegistroAdopcion actual);
	public void eliminar(RegistroAdopcion eliminado);
	public List<RegistroAdopcion> listar();
	public List<RegistroAdopcion> buscarPorRaza(Raza raza);
	public List<RegistroAdopcion> buscarPorPropietario(Propietario propietario);
	public List<RegistroAdopcion> buscarPorEmpleado(Empleado empleado);

}
