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

import com.ectur.controlador.EmpleadoControlador;
import com.ectur.controlador.impl.EmpleadoControladorImpl;
import com.ectur.modelo.entidad.Empleado;

@ManagedBean
@ViewScoped
public class EmpleadoVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpleadoControlador empleadocontrolador;
	private Empleado empleado;
	private List<Empleado> listado = new ArrayList<Empleado>();

	@PostConstruct
	public void init() {
		empleadocontrolador = new EmpleadoControladorImpl();
		empleado = new Empleado();
		listar();

	}

	public void crear() {
		empleado = new Empleado();
		PrimeFaces.current().ajax().update("formEmpleado:mensajes", "formEmpleado:dlgFormulario");
	}

	public void guardar() {

		if (empleado.getId() > 0) {
			empleadocontrolador.actualizar(empleado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado actualizada correctamente."));
		} else {
			empleadocontrolador.insertar(empleado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado creada correctamente."));
		}

		listar();
		PrimeFaces.current().ajax().update("formEmpleado:mensajes", "formEmpleado:dt_empleados");
	}

	public void eliminar() {
		try {
			empleadocontrolador.eliminar(empleado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado eliminada correctamente"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Empleado no se eliminó porque está a cargo de adopciones", null));

		}
		listar();
		PrimeFaces.current().ajax().update("formEmpleado:mensajes", "formEmpleado:dt_empleados");
	}

	public void listar() {
		listado = empleadocontrolador.listar();
	}

	// -------------------------------------------------
	public EmpleadoControlador getEmpleadocontrolador() {
		return empleadocontrolador;
	}

	public void setEmpleadocontrolador(EmpleadoControlador empleadocontrolador) {
		this.empleadocontrolador = empleadocontrolador;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getListado() {
		return listado;
	}

	public void setListado(List<Empleado> listado) {
		this.listado = listado;
	}

}
