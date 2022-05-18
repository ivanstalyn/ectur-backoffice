package com.ectur.modelo.entidad;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "mensaje")
	private String mensaje;
	
	@Column(name = "fec_inicio_evento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioEvento;
	
	@Column(name = "fec_final_evento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinalEvento;
	
	@NotNull
	@Column(name = "fec_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name = "fec_actualizacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_id")
	private DetalleCatalogo estado;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaInicioEvento() {
		return fechaInicioEvento;
	}

	public void setFechaInicioEvento(Date fechaInicioEvento) {
		this.fechaInicioEvento = fechaInicioEvento;
	}

	public Date getFechaFinalEvento() {
		return fechaFinalEvento;
	}

	public void setFechaFinalEvento(Date fechaFinalEvento) {
		this.fechaFinalEvento = fechaFinalEvento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public DetalleCatalogo getEstado() {
		return estado;
	}

	public void setEstado(DetalleCatalogo estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Solicitud [id=" + id + 
				", mensaje=" + mensaje + 
				", fechaInicioEvento=" + (new SimpleDateFormat("yyyy-MM-dd").format(fechaInicioEvento)) +
				", fechaFinalEvento=" + (new SimpleDateFormat("yyyy-MM-dd").format(fechaFinalEvento)) + 
				", fechaCreacion=" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(fechaCreacion)) + 
				", fechaActualizacion=" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(fechaActualizacion)) + 
				", estado=" + estado + 
				", usuario=" + usuario	+ 
				", producto=" + producto + "]";
	}
	
	

}