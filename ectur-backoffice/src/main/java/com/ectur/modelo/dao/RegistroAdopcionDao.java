package com.ectur.modelo.dao;

import java.util.List;

import com.ectur.modelo.entidad.Empleado;
import com.ectur.modelo.entidad.Propietario;
import com.ectur.modelo.entidad.Raza;
import com.ectur.modelo.entidad.RegistroAdopcion;

public interface RegistroAdopcionDao {
	public void insertar(RegistroAdopcion nuevo);
	public void actualizar(RegistroAdopcion actual);
	public void eliminar(RegistroAdopcion eliminado);
	public List<RegistroAdopcion> listar();
	public List<RegistroAdopcion> porRaza(Raza raza);
	public List<RegistroAdopcion> porPropietario(Propietario propietario);
	public List<RegistroAdopcion> porEmpleado(Empleado empleado);
	


}
