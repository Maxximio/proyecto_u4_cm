package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="persona")
//@NamedQuery(name = "Persona.buscarPorCedula",query="select p from Persona p where p.cedula =:datoCedula")
//@NamedQuery(name = "Persona.buscarNombreApellido",query="select p from Persona p where p.nombre =:datoNombre and p.apellido =:datoApellido")
@NamedQueries({
	@NamedQuery(name = "Persona.buscarPorCedula",query="select p from Persona p where p.cedula =:datoCedula")
	,@NamedQuery(name = "Persona.buscarNombreApellido",query="select p from Persona p where p.nombre =:datoNombre and p.apellido =:datoApellido")
	})
@NamedNativeQuery(name="Persona.buscarPorCedulaNative",query="select * from persona where pers_cedula =:datoCedula",resultClass = Persona.class)
public class Persona {
	
	@Id
	@Column(name="pers_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pers_id_seq")
	@SequenceGenerator(name = "pers_id_seq",sequenceName = "pers_id_seq",allocationSize = 1)
	private Integer id;
	
	@Column(name="pers_nombre")
	private String nombre;
	
	@Column(name="pers_genero")
	private String genero;
	
	@Column(name="pers_cedula")
	private String cedula;
	
	@Column(name="pers_apellido")
	private String apellido;
	
	//set y get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	//to string
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", cedula=" + cedula + ", apellido="
				+ apellido + "]";
	}
	
}
