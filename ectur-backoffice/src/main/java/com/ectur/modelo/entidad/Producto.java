package com.ectur.modelo.entidad;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "foto")
	private String foto;
	
	@NotNull
	@Column(name = "fec_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
		
	@Column(name = "fec_inicio_evento")
	@Temporal(TemporalType.DATE)
	private Date fechaInicioEvento;
	
	@Column(name = "fec_final_evento")
	@Temporal(TemporalType.DATE)
	private Date fechaFinalEvento;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "producto", fetch = FetchType.LAZY)
	private List<Solicitud>listaSolicitudes = new ArrayList<Solicitud>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + 
				", nombre=" + nombre + 
				", descripcion=" + descripcion + 
				", precio=" + precio +
				", foto=" + foto + 
				", fechaCreacion=" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(fechaCreacion)) + 
				", fechaInicioEvento=" + (new SimpleDateFormat("yyyy-MM-dd").format(fechaInicioEvento)) +
				", fechaFinalEvento=" + (new SimpleDateFormat("yyyy-MM-dd").format(fechaFinalEvento)) + 
				", empresa=" + empresa + 
				", listaSolicitudes=" + listaSolicitudes + "]";
	}
	
	
		

}