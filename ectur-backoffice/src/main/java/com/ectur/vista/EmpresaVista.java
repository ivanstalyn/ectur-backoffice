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

import com.ectur.controlador.EmpresaControlador;
import com.ectur.controlador.impl.EmpresaControladorImpl;
import com.ectur.modelo.entidad.Empresa;


@ManagedBean
@ViewScoped
public class EmpresaVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmpresaControlador empresacontrolador;
	private Empresa empresa;
	private List<Empresa> listado = new ArrayList<Empresa>();
	
	@PostConstruct
	public void init() {
		empresacontrolador = new EmpresaControladorImpl();
		empresa = new Empresa();
		listar();
		
	}
	
	public void crear() {
		empresa = new Empresa();
		PrimeFaces.current().ajax().update("formEmpresa:mensajes", "formEmpresa:dlgFormulario");		
	}
	
	public void guardar() {
		
		if(empresa.getId()>0) {
			empresacontrolador.actualizar(empresa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empresa actualizada correctamente."));
		} else {
			empresacontrolador.insertar(empresa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empresa creada correctamente."));
		}
		
		listar();
		PrimeFaces.current().ajax().update("formEmpresa:mensajes", "formEmpresa:dt_empresas");
	}
	
	public void eliminar() {
		try {
		empresacontrolador.eliminar(empresa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empresa eliminada correctamente"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Empresa no se eliminó porque está asociada a un Producto", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formEmpresa:mensajes", "formEmpresa:dt_empresas");
	}
	
	public void listar() {
		listado = empresacontrolador.listar();
	}

	//-------------------------------------------------
	public EmpresaControlador getEmpresacontrolador() {
		return empresacontrolador;
	}

	public void setEmpresacontrolador(EmpresaControlador empresacontrolador) {
		this.empresacontrolador = empresacontrolador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getListado() {
		return listado;
	}

	public void setListado(List<Empresa> listado) {
		this.listado = listado;
	}
	
}
