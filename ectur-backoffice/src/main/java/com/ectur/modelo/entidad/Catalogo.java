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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45)
	private String nombre;
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "catalogo", fetch = FetchType.LAZY)
	private List<DetalleCatalogo>listaDetalleCatalogo = new ArrayList<DetalleCatalogo>();

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

	public List<DetalleCatalogo> getListaDetalleCatalogo() {
		return listaDetalleCatalogo;
	}

	public void setListaDetalleCatalogo(List<DetalleCatalogo> listaDetalleCatalogo) {
		this.listaDetalleCatalogo = listaDetalleCatalogo;
	}

	@Override
	public String toString() {
		return "Catalogo [id=" + id + ", nombre=" + nombre + ", listaDetalleCatalogo=" + listaDetalleCatalogo + "]";
	}
	
	

}