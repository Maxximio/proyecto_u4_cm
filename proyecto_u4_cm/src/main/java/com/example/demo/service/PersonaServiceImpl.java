package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPersonaRepository;
import com.example.demo.repository.modelo.Persona;
import com.example.demo.repository.modelo.PersonaTo;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepository personaJpaRepository;
	
	@Override
	public void insertarService(Persona persona) {
		this.personaJpaRepository.insertar(persona);
	}

	@Override
	public Persona buscarPersonaIdService(Integer id) {
		return this.personaJpaRepository.buscarPersonaId(id);
	}

	@Override
	public void actualizarService(Persona persona) {
		this.personaJpaRepository.actualizar(persona);
	}

	@Override
	public void eliminarService(Integer id) {
		this.personaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarPersonaCedulaService(String cedula) {
		return this.personaJpaRepository.buscarPersonaCedula(cedula);
	}

	@Override
	public Persona buscarPersonaCedulaTypedService(String cedula) {
		return this.personaJpaRepository.buscarPersonaCedulaTyped(cedula);
	}

	@Override
	public Persona buscarPersonaCedulaCriteriaService(String cedula) {
		return this.personaJpaRepository.buscarPersonaCedulaCriteria(cedula);
	}

	@Override
	public List<PersonaTo> buscarPersonaSencillaApellidoService(String apellido) {
		return this.personaJpaRepository.buscarPersonaSencillaApellido(apellido);
	}

	@Override
	public List<Persona> buscarTodosService() {
		return this.personaJpaRepository.buscarTodos();
	}

}
