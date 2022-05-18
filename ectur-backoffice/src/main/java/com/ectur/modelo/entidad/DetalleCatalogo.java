package com.ectur.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
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

@Entity
@Table(name = "detalle_catalogo")
public class DetalleCatalogo implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45)
	private String nombre;
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "rol", fetch = FetchType.LAZY)
	private List<Usuario>listaUsuariosPorRol = new ArrayList<Usuario>();
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "genero", fetch = FetchType.LAZY)
	private List<Usuario>listaUsuariosPorGenero = new ArrayList<Usuario>();
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "estado", fetch = FetchType.LAZY)
	private List<Solicitud>listaSolicitudPorEstado = new ArrayList<Solicitud>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "catalogo_id")
	private Catalogo catalogo;

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

	public List<Usuario> getListaUsuariosPorRol() {
		return listaUsuariosPorRol;
	}

	public void setListaUsuariosPorRol(List<Usuario> listaUsuariosPorRol) {
		this.listaUsuariosPorRol = listaUsuariosPorRol;
	}

	public List<Usuario> getListaUsuariosPorGenero() {
		return listaUsuariosPorGenero;
	}

	public void setListaUsuariosPorGenero(List<Usuario> listaUsuariosPorGenero) {
		this.listaUsuariosPorGenero = listaUsuariosPorGenero;
	}

	public List<Solicitud> getListaSolicitudPorEstado() {
		return listaSolicitudPorEstado;
	}

	public void setListaSolicitudPorEstado(List<Solicitud> listaSolicitudPorEstado) {
		this.listaSolicitudPorEstado = listaSolicitudPorEstado;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public String toString() {
		return "DetalleCatalogo [id=" + id + ", nombre=" + nombre + ", listaUsuariosPorRol=" + listaUsuariosPorRol
				+ ", listaUsuariosPorGenero=" + listaUsuariosPorGenero + ", listaSolicitudPorEstado="
				+ listaSolicitudPorEstado + ", catalogo=" + catalogo + "]";
	}
	
	
}