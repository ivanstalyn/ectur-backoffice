package com.ectur.controlador;

import java.util.List;

import com.ectur.modelo.entidad.Catalogo;
import com.ectur.modelo.entidad.DetalleCatalogo;

public interface DetalleCatalogoControlador {
	
	public void insertar(DetalleCatalogo nuevo);
	public void actualizar(DetalleCatalogo actual);
	public void eliminar(DetalleCatalogo eliminado);
	public List<DetalleCatalogo> listar();
	public DetalleCatalogo buscarPorId(int id);
	public List<DetalleCatalogo> buscarPorCatalogo(Catalogo catalogo);

}
