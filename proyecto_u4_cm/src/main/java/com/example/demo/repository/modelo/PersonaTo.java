package com.example.demo.repository.modelo;

import java.io.Serializable;

public class PersonaTo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String apellido;

	public PersonaTo(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	//set y get
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

	//to string
	@Override
	public String toString() {
		return "PersonaTo [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
	
}
