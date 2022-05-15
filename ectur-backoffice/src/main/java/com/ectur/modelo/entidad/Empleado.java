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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45)
	private String nombre;
	
	@Column(length = 10)
	private String cedula;
	
	@Column(length = 1)
	private String sexo;
	
	private Date fechaNacimiento;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "empleado", fetch = FetchType.LAZY)
	private List<RegistroAdopcion>listaRegistroAdopcion = new ArrayList<RegistroAdopcion>();

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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	@SuppressWarnings("deprecation")
	public int getEdad() {
		return (new Date().getYear()) - this.fechaNacimiento.getYear();
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", fechaNacimiento=" + (new SimpleDateFormat("yyyy-MM-dd").format(fechaNacimiento)) + ", sexo=" + sexo + "]";
	}
	
	
	

}
