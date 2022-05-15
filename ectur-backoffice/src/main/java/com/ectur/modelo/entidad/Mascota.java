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



@Entity
@Table(name = "mascota")
public class Mascota implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45)
	private String nombre;
	
	private Date fechaNacimiento;
	
	@Column(length = 1)
	private String sexo;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "raza_id")
	private Raza raza;
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "mascota", fetch = FetchType.LAZY)
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Raza getRaza() {
		return raza;
	}
	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	@SuppressWarnings("deprecation")
	public int getEdad() {
		return (new Date().getYear()) - this.fechaNacimiento.getYear();
	}
	
	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + (new SimpleDateFormat("yyyy-mm-dd").format(fechaNacimiento)) + ", sexo=" + sexo
				+ ", raza =" + raza + ", Edad = "
				+ getEdad() + "]";
	}

}
