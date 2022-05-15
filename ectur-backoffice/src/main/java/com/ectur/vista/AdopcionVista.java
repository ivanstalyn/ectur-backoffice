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
import com.ectur.controlador.MascotaControlador;
import com.ectur.controlador.PropietarioControlador;
import com.ectur.controlador.RegistroAdopcionControlador;
import com.ectur.controlador.impl.EmpleadoControladorImpl;
import com.ectur.controlador.impl.MascotaControladorImpl;
import com.ectur.controlador.impl.PropietarioControladorImpl;
import com.ectur.controlador.impl.RegistroAdopcionControladorImpl;
import com.ectur.modelo.entidad.Empleado;
import com.ectur.modelo.entidad.Mascota;
import com.ectur.modelo.entidad.Propietario;

import com.ectur.modelo.entidad.RegistroAdopcion;

@ManagedBean
@ViewScoped
public class AdopcionVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MascotaControlador mascotacontrolador;
	private EmpleadoControlador empleadocontrolador;
	private PropietarioControlador propietariocontrolador;
	private RegistroAdopcionControlador registroadopcioncontrolador;
	
	private Mascota mascota;
	private Empleado empleado;
	private Propietario propietario;
	private RegistroAdopcion registroadopcion;
	
	private List<Mascota> listaMascotas = new ArrayList<Mascota>();
	private List<Empleado>listaEmpleados = new ArrayList<Empleado>();
	private List<Propietario> listaPropietarios = new ArrayList<Propietario>();
	private List<RegistroAdopcion> listado = new ArrayList<RegistroAdopcion>();
	
	private int mascotaId;
	private int empleadoId;
	private int propietarioId;

	@PostConstruct
	public void init() {
		mascotacontrolador = new MascotaControladorImpl();
		empleadocontrolador = new EmpleadoControladorImpl();
		propietariocontrolador = new PropietarioControladorImpl();
		registroadopcioncontrolador = new RegistroAdopcionControladorImpl();
		
		mascota = new Mascota();
		empleado = new Empleado();
		propietario = new Propietario();
		registroadopcion = new RegistroAdopcion();
		listarRegistrosAdopcion();
		listarMascotas();
		listarEmpleados();
		listarPropietarios();

	}

	public void crear() {
		mascota = new Mascota();
		empleado = new Empleado();
		propietario = new Propietario();
		registroadopcion = new RegistroAdopcion();
		PrimeFaces.current().ajax().update("formRegAdop:mensajes", "formRegAdop:dlgFormulario");
	}

	public void guardar() {
		
		registroadopcion.setPropietario(propietariocontrolador.buscarPorId(propietarioId));
		registroadopcion.setEmpleado(empleadocontrolador.buscarPorId(empleadoId));
		registroadopcion.setMascota(mascotacontrolador.buscarPorId(mascotaId));
		
		if (registroadopcion.getId() > 0) {
			registroadopcioncontrolador.actualizar(registroadopcion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro de adopción actualizado correctamente."));
		} else {
			registroadopcioncontrolador.insertar(registroadopcion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro de adopción creado correctamente."));
		}

		listarRegistrosAdopcion();
		PrimeFaces.current().ajax().update("formRegAdop:mensajes", "formRegAdop:dt_registroadopcion");
	}

	public void eliminar() {
		try {
			registroadopcioncontrolador.eliminar(registroadopcion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro de adopción eliminado correctamente"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro de adopción no se eliminó", null));
		}
		listarRegistrosAdopcion();
		PrimeFaces.current().ajax().update("formRegAdop:mensajes", "formRegAdop:dt_registroadopcion");
	}

	
	public void listarRegistrosAdopcion() {
		listado = registroadopcioncontrolador.listar();
	}
	public void listarMascotas() {
		listaMascotas = mascotacontrolador.listar();
	}
	public void listarEmpleados() {
		listaEmpleados = empleadocontrolador.listar();
	}
	public void listarPropietarios() {
		listaPropietarios = propietariocontrolador.listar();
	}
	
	// -------------------------------------------------

	public MascotaControlador getMascotacontrolador() {
		return mascotacontrolador;
	}

	public void setMascotacontrolador(MascotaControlador mascotacontrolador) {
		this.mascotacontrolador = mascotacontrolador;
	}

	public EmpleadoControlador getEmpleadocontrolador() {
		return empleadocontrolador;
	}

	public void setEmpleadocontrolador(EmpleadoControlador empleadocontrolador) {
		this.empleadocontrolador = empleadocontrolador;
	}

	public PropietarioControlador getPropietariocontrolador() {
		return propietariocontrolador;
	}

	public void setPropietariocontrolador(PropietarioControlador propietariocontrolador) {
		this.propietariocontrolador = propietariocontrolador;
	}

	public RegistroAdopcionControlador getRegistroadopcioncontrolador() {
		return registroadopcioncontrolador;
	}

	public void setRegistroadopcioncontrolador(RegistroAdopcionControlador registroadopcioncontrolador) {
		this.registroadopcioncontrolador = registroadopcioncontrolador;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public RegistroAdopcion getRegistroadopcion() {
		return registroadopcion;
	}

	public void setRegistroadopcion(RegistroAdopcion registroadopcion) {
		this.registroadopcion = registroadopcion;
	}

	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public List<Propietario> getListaPropietarios() {
		return listaPropietarios;
	}

	public void setListaPropietarios(List<Propietario> listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
	}

	public List<RegistroAdopcion> getListado() {
		return listado;
	}

	public void setListado(List<RegistroAdopcion> listado) {
		this.listado = listado;
	}

	public int getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(int mascotaId) {
		this.mascotaId = mascotaId;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public int getPropietarioId() {
		return propietarioId;
	}

	public void setPropietarioId(int propietarioId) {
		this.propietarioId = propietarioId;
	}

	

	
}
