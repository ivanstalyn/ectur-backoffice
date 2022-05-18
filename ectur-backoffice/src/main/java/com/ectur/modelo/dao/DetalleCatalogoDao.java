package com.ectur.modelo.dao;

import java.util.List;

import com.ectur.modelo.entidad.Catalogo;
import com.ectur.modelo.entidad.DetalleCatalogo;

public interface DetalleCatalogoDao {
	public void insertar(DetalleCatalogo nuevo);
	public void actualizar(DetalleCatalogo actual);
	public void eliminar(DetalleCatalogo eliminado);
	public DetalleCatalogo buscarPorId(int id);
	public List<DetalleCatalogo> buscarPorCatalogo(Catalogo catalogo);
	public List<DetalleCatalogo> listar();
	
}
