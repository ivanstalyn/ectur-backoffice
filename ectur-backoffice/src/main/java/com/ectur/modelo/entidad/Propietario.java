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
@Table(name = "propietario")
public class Propietario implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 10)
	private String cedula;
	
	@Column(length = 45)
	private String nombre;
	
	@Column(length = 45)
	private String celular;
	
	@Column(length = 45)
	private String email;
	
	@Column(length = 45)
	private String direcion;
	
	@Column(length = 1)
	private String sexo;
	
	private Date fechaNacimiento;
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "propietario", fetch = FetchType.LAZY)
	private List<RegistroAdopcion>listaRegistroAdopcion = new ArrayList<RegistroAdopcion>();

	public List<RegistroAdopcion> getListaRegistroAdopcion() {
		return listaRegistroAdopcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
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
		return "Propietario [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", celular=" + celular
				+ ", email=" + email + ", direcion=" + direcion + ", sexo=" + sexo + ", fechaNacimiento="
				+ (new SimpleDateFormat("yyyy-MM-dd").format(fechaNacimiento)) + ", getEdad()=" + getEdad()
				+  "]";
	}
	
	

}

