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

import com.ectur.controlador.RazaControlador;
import com.ectur.controlador.impl.RazaControladorImpl;
import com.ectur.modelo.entidad.Raza;


@ManagedBean
@ViewScoped
public class RazaVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RazaControlador razacontrolador;
	private Raza raza;
	private List<Raza> listado = new ArrayList<Raza>();
	
	@PostConstruct
	public void init() {
		razacontrolador = new RazaControladorImpl();
		raza = new Raza();
		listar();
		
	}
	
	public void crear() {
		raza = new Raza();
		PrimeFaces.current().ajax().update("formRaza:mensajes", "formRaza:dlgFormulario");		
	}
	
	public void guardar() {
		
		if(raza.getId()>0) {
			razacontrolador.actualizar(raza);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Raza actualizada correctamente."));
		} else {
			razacontrolador.insertar(raza);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Raza creada correctamente."));
		}
		
		listar();
		PrimeFaces.current().ajax().update("formRaza:mensajes", "formRaza:dt_razas");
	}
	
	public void eliminar() {
		try {
		razacontrolador.eliminar(raza);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Raza eliminada correctamente"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Raza no se eliminó porque está asociada a una mascota", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formRaza:mensajes", "formRaza:dt_razas");
	}
	
	public void listar() {
		listado = razacontrolador.listar();
	}

	//-------------------------------------------------
	public RazaControlador getRazacontrolador() {
		return razacontrolador;
	}

	public void setRazacontrolador(RazaControlador razacontrolador) {
		this.razacontrolador = razacontrolador;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public List<Raza> getListado() {
		return listado;
	}

	public void setListado(List<Raza> listado) {
		this.listado = listado;
	}
	
}
