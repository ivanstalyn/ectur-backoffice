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

import com.ectur.controlador.DetalleCatalogoControlador;
import com.ectur.controlador.CatalogoControlador;
import com.ectur.controlador.impl.DetalleCatalogoControladorImpl;
import com.ectur.controlador.impl.CatalogoControladorImpl;
import com.ectur.modelo.entidad.DetalleCatalogo;
import com.ectur.modelo.entidad.Catalogo;

@ManagedBean
@ViewScoped
public class DetalleCatalogoVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DetalleCatalogoControlador detalleCatalogocontrolador;
	private CatalogoControlador catalogocontrolador;
	private DetalleCatalogo detalleCatalogo;
	private Catalogo catalogo;
	private List<DetalleCatalogo> listado = new ArrayList<DetalleCatalogo>();
	private List<Catalogo> listadoCatalogos = new ArrayList<Catalogo>();

	private int catalogoId;

	@PostConstruct
	public void init() {
		detalleCatalogocontrolador = new DetalleCatalogoControladorImpl();
		catalogocontrolador = new CatalogoControladorImpl();
		detalleCatalogo = new DetalleCatalogo();
		catalogo = new Catalogo();
		listar();
		listarCatalogos();

	}

	public void crear() {
		detalleCatalogo = new DetalleCatalogo();
		catalogo = new Catalogo();
		PrimeFaces.current().ajax().update("formDetalleCatalogo:mensajes", "formDetalleCatalogo:dlgFormulario");
	}

	public void guardar() {

		detalleCatalogo.setCatalogo(catalogocontrolador.buscarPorId(catalogoId));
		if (detalleCatalogo.getId() > 0) {
			detalleCatalogocontrolador.actualizar(detalleCatalogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Subcatálogo actualizado correctamente."));
		} else {
			detalleCatalogocontrolador.insertar(detalleCatalogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Subcatálogo creado correctamente."));
		}

		listar();
		PrimeFaces.current().ajax().update("formDetalleCatalogo:mensajes", "formDetalleCatalogo:dt_detalleCatalogos");
	}

	public void eliminar() {
		try {
			detalleCatalogocontrolador.eliminar(detalleCatalogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Subcatálogo eliminado correctamente"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Subcatálogo no se eliminó", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formDetalleCatalogo:mensajes", "formDetalleCatalogo:dt_detalleCatalogos");
	}

	public void listar() {
		listado = detalleCatalogocontrolador.listar();
	}

	public void listarCatalogos() {
		listadoCatalogos = catalogocontrolador.listar();
	}

	// -------------------------------------------------
	public DetalleCatalogoControlador getDetalleCatalogocontrolador() {
		return detalleCatalogocontrolador;
	}

	public void setDetalleCatalogocontrolador(DetalleCatalogoControlador detalleCatalogocontrolador) {
		this.detalleCatalogocontrolador = detalleCatalogocontrolador;
	}

	public DetalleCatalogo getDetalleCatalogo() {
		return detalleCatalogo;
	}

	public void setDetalleCatalogo(DetalleCatalogo detalleCatalogo) {
		this.detalleCatalogo = detalleCatalogo;
	}

	public List<DetalleCatalogo> getListado() {
		return listado;
	}

	public void setListado(List<DetalleCatalogo> listado) {
		this.listado = listado;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public List<Catalogo> getListadoCatalogos() {
		return listadoCatalogos;
	}

	public void setListadoCatalogos(List<Catalogo> listadoCatalogos) {
		this.listadoCatalogos = listadoCatalogos;
	}

	public CatalogoControlador getCatalogocontrolador() {
		return catalogocontrolador;
	}

	public void setCatalogocontrolador(CatalogoControlador catalogocontrolador) {
		this.catalogocontrolador = catalogocontrolador;
	}

	public int getCatalogoId() {
		return catalogoId;
	}

	public void setCatalogoId(int catalogoId) {
		this.catalogoId = catalogoId;
	}

}
