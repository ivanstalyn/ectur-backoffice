package com.ectur.controlador;

import java.util.List;

import com.ectur.modelo.entidad.Empresa;

public interface EmpresaControlador {
	
	public void insertar(Empresa nuevo);
	public void actualizar(Empresa actual);
	public void eliminar(Empresa eliminado);
	public List<Empresa> listar();
	public Empresa buscarPorId(int id);

}
