package com.ectur.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.ectur.controlador.DetalleCatalogoControlador;
import com.ectur.controlador.SolicitudControlador;
import com.ectur.controlador.UsuarioControlador;
import com.ectur.controlador.impl.DetalleCatalogoControladorImpl;
import com.ectur.controlador.impl.SolicitudControladorImpl;
import com.ectur.controlador.impl.UsuarioControladorImpl;
import com.ectur.modelo.entidad.DetalleCatalogo;
import com.ectur.modelo.entidad.Solicitud;
import com.ectur.modelo.entidad.Usuario;

@ManagedBean
@ViewScoped
public class SolicitudVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SolicitudControlador solicitudcontrolador;
	private UsuarioControlador usuariocontrolador;
	private DetalleCatalogoControlador detalleCatalogocontrolador;
	private Solicitud solicitud;
	private Usuario usuario;
	private DetalleCatalogo detalleCatalogo;
	private List<Solicitud> listado = new ArrayList<Solicitud>();
	private List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
	private List<DetalleCatalogo> listadoDetalleCatalogos = new ArrayList<DetalleCatalogo>();

	private int usuarioId;
	private int detalleCatalogoId;

	@PostConstruct
	public void init() {
		solicitudcontrolador = new SolicitudControladorImpl();
		usuariocontrolador = new UsuarioControladorImpl();
		detalleCatalogocontrolador = new DetalleCatalogoControladorImpl();
		solicitud = new Solicitud();
		usuario = new Usuario();
		detalleCatalogo = new DetalleCatalogo();
		listar();
		listarUsuarios();

	}

	public void crear() {
		solicitud = new Solicitud();
		usuario = new Usuario();
		PrimeFaces.current().ajax().update("formSolicitud:mensajes", "formSolicitud:dlgFormulario");
	}

	public void guardar() {

		solicitud.setUsuario(usuariocontrolador.buscarPorId(usuarioId));
		solicitud.setEstado(detalleCatalogocontrolador.buscarPorId(detalleCatalogoId));
		if (solicitud.getId() > 0) {
			
			solicitudcontrolador.actualizar(solicitud);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud actualizado correctamente."));
		} else {
			solicitud.setFechaCreacion(new Date(System.currentTimeMillis()));
			solicitudcontrolador.insertar(solicitud);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud creado correctamente."));
		}

		listar();
		PrimeFaces.current().ajax().update("formSolicitud:mensajes", "formSolicitud:dt_solicituds");
	}

	public void eliminar() {
		try {
			solicitudcontrolador.eliminar(solicitud);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud eliminado correctamente"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud no se eliminó", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formSolicitud:mensajes", "formSolicitud:dt_solicituds");
	}

	public void listar() {
		listado = solicitudcontrolador.listar();
	}

	public void listarUsuarios() {
		listadoUsuarios = usuariocontrolador.listar();
	}

	// -------------------------------------------------
	public SolicitudControlador getSolicitudcontrolador() {
		return solicitudcontrolador;
	}

	public void setSolicitudcontrolador(SolicitudControlador solicitudcontrolador) {
		this.solicitudcontrolador = solicitudcontrolador;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public List<Solicitud> getListado() {
		return listado;
	}

	public void setListado(List<Solicitud> listado) {
		this.listado = listado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListadoUsuarios() {
		return listadoUsuarios;
	}

	public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
		this.listadoUsuarios = listadoUsuarios;
	}

	public UsuarioControlador getUsuariocontrolador() {
		return usuariocontrolador;
	}

	public void setUsuariocontrolador(UsuarioControlador usuariocontrolador) {
		this.usuariocontrolador = usuariocontrolador;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

}
