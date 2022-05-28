package com.ectur.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.ectur.controlador.CatalogoControlador;
import com.ectur.controlador.impl.CatalogoControladorImpl;
import com.ectur.modelo.entidad.Catalogo;


@ManagedBean
@ViewScoped
public class CatalogoVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CatalogoControlador catalogocontrolador;
	private Catalogo catalogo;
	private List<Catalogo> listado = new ArrayList<Catalogo>();
	
	@PostConstruct
	public void init() {
		catalogocontrolador = new CatalogoControladorImpl();
		catalogo = new Catalogo();
		listar();
		
	}
	
	public void crear() {
		catalogo = new Catalogo();
		PrimeFaces.current().ajax().update("formCatalogo:mensajes", "formCatalogo:dlgFormulario");		
	}
	
	public void guardar() {
		
		if(catalogo.getId()>0) {
			catalogocontrolador.actualizar(catalogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Catalogo actualizada correctamente."));
		} else {
			catalogocontrolador.insertar(catalogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Catalogo creada correctamente."));
		}
		
		listar();
		PrimeFaces.current().ajax().update("formCatalogo:mensajes", "formCatalogo:dt_catalogos");
	}
	
	public void eliminar() {
		try {
		catalogocontrolador.eliminar(catalogo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Catalogo eliminada correctamente"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Catalogo no se eliminó porque está asociada a un Producto", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formCatalogo:mensajes", "formCatalogo:dt_catalogos");
	}
	
	public void listar() {
		listado = catalogocontrolador.listar();
	}

	//-------------------------------------------------
	public CatalogoControlador getCatalogocontrolador() {
		return catalogocontrolador;
	}

	public void setCatalogocontrolador(CatalogoControlador catalogocontrolador) {
		this.catalogocontrolador = catalogocontrolador;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public List<Catalogo> getListado() {
		return listado;
	}

	public void setListado(List<Catalogo> listado) {
		this.listado = listado;
	}
	
}
