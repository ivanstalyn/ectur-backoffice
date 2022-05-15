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

import com.ectur.controlador.MascotaControlador;
import com.ectur.controlador.RazaControlador;
import com.ectur.controlador.impl.MascotaControladorImpl;
import com.ectur.controlador.impl.RazaControladorImpl;
import com.ectur.modelo.entidad.Mascota;
import com.ectur.modelo.entidad.Raza;

@ManagedBean
@ViewScoped
public class MascotaVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MascotaControlador mascotacontrolador;
	private RazaControlador razacontrolador;
	private Mascota mascota;
	private Raza raza;
	private List<Mascota> listado = new ArrayList<Mascota>();
	private List<Raza> listadoRazas = new ArrayList<Raza>();

	private int razaId;

	@PostConstruct
	public void init() {
		mascotacontrolador = new MascotaControladorImpl();
		razacontrolador = new RazaControladorImpl();
		mascota = new Mascota();
		raza = new Raza();
		listar();
		listarRazas();

	}

	public void crear() {
		mascota = new Mascota();
		raza = new Raza();
		PrimeFaces.current().ajax().update("formMascota:mensajes", "formMascota:dlgFormulario");
	}

	public void guardar() {

		mascota.setRaza(razacontrolador.buscarPorId(razaId));
		if (mascota.getId() > 0) {
			mascotacontrolador.actualizar(mascota);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mascota actualizada correctamente."));
		} else {
			mascotacontrolador.insertar(mascota);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mascota creada correctamente."));
		}

		listar();
		PrimeFaces.current().ajax().update("formMascota:mensajes", "formMascota:dt_mascotas");
	}

	public void eliminar() {
		try {
			mascotacontrolador.eliminar(mascota);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mascota eliminada correctamente"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mascota no se eliminó porque está adoptada", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formMascota:mensajes", "formMascota:dt_mascotas");
	}

	public void listar() {
		listado = mascotacontrolador.listar();
	}

	public void listarRazas() {
		listadoRazas = razacontrolador.listar();
	}

	// -------------------------------------------------
	public MascotaControlador getMascotacontrolador() {
		return mascotacontrolador;
	}

	public void setMascotacontrolador(MascotaControlador mascotacontrolador) {
		this.mascotacontrolador = mascotacontrolador;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public List<Mascota> getListado() {
		return listado;
	}

	public void setListado(List<Mascota> listado) {
		this.listado = listado;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public List<Raza> getListadoRazas() {
		return listadoRazas;
	}

	public void setListadoRazas(List<Raza> listadoRazas) {
		this.listadoRazas = listadoRazas;
	}

	public RazaControlador getRazacontrolador() {
		return razacontrolador;
	}

	public void setRazacontrolador(RazaControlador razacontrolador) {
		this.razacontrolador = razacontrolador;
	}

	public int getRazaId() {
		return razaId;
	}

	public void setRazaId(int razaId) {
		this.razaId = razaId;
	}

}
