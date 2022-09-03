package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Persona;
import com.example.demo.repository.modelo.PersonaTo;

public interface IPersonaService {

public void insertarService(Persona persona);
	
	public Persona buscarPersonaIdService(Integer id);
	
	public void actualizarService(Persona persona);
	
	public void eliminarService(Integer id);
	
	public List<Persona> buscarTodosService();
	
	public Persona buscarPersonaCedulaService(String cedula);//normal
	
	public Persona buscarPersonaCedulaTypedService(String cedula);//typed
	

	public Persona buscarPersonaCedulaCriteriaService(String cedula);

	public List<PersonaTo> buscarPersonaSencillaApellidoService(String apellido);
}
