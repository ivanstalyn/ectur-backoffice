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

import com.ectur.controlador.PropietarioControlador;
import com.ectur.controlador.impl.PropietarioControladorImpl;
import com.ectur.modelo.entidad.Propietario;

@ManagedBean
@ViewScoped
public class PropietarioVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PropietarioControlador propietariocontrolador;
	private Propietario propietario;
	private List<Propietario> listado = new ArrayList<Propietario>();

	@PostConstruct
	public void init() {
		propietariocontrolador = new PropietarioControladorImpl();
		propietario = new Propietario();
		listar();

	}

	public void crear() {
		propietario = new Propietario();
		PrimeFaces.current().ajax().update("formPropietario:mensajes", "formPropietario:dlgFormulario");
	}

	public void guardar() {

		if (propietario.getId() > 0) {
			propietariocontrolador.actualizar(propietario);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Propietario actualizada correctamente."));
		} else {
			propietariocontrolador.insertar(propietario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propietario creada correctamente."));
		}

		listar();
		PrimeFaces.current().ajax().update("formPropietario:mensajes", "formPropietario:dt_propietarios");
	}

	public void eliminar() {
		try {
			propietariocontrolador.eliminar(propietario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propietario eliminada correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Propietario no se eliminó porque tiene mascotas adoptadas", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formPropietario:mensajes", "formPropietario:dt_propietarios");
	}

	public void listar() {
		listado = propietariocontrolador.listar();
	}

	// -------------------------------------------------
	public PropietarioControlador getPropietariocontrolador() {
		return propietariocontrolador;
	}

	public void setPropietariocontrolador(PropietarioControlador propietariocontrolador) {
		this.propietariocontrolador = propietariocontrolador;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Propietario> getListado() {
		return listado;
	}

	public void setListado(List<Propietario> listado) {
		this.listado = listado;
	}

}
