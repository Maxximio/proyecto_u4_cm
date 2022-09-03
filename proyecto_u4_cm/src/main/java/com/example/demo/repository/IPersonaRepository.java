package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Persona;
import com.example.demo.repository.modelo.PersonaTo;


public interface IPersonaRepository {

	public void insertar(Persona persona);
	
	public Persona buscarPersonaId(Integer id);
	
	public void actualizar(Persona persona);
	
	public void eliminar(Integer id);
	
	public List<Persona> buscarTodos();
	
	public Persona buscarPersonaCedula(String cedula);//normal
	
	public Persona buscarPersonaCedulaTyped(String cedula);//typed
	

	public Persona buscarPersonaCedulaCriteria(String cedula);

	public List<PersonaTo> buscarPersonaSencillaApellido(String apellido);
	
	
}
