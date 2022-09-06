package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Persona;
import com.example.demo.service.IPersonaService;


@Controller
@RequestMapping("/personas")//"http://localhost:8080/personas"
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	
	@GetMapping("/buscar")//get
	public String buscarTodos(Model modelo){
		List<Persona> lista=this.personaService.buscarTodosService();
		modelo.addAttribute("personas",lista);//el personas sera referenciado y
		//persona es el nombre que le ponemos 
		return "vistaListaPersonas";
	}
	
	@GetMapping("/buscarUno/{idPersona}")
	public String buscarPersona(@PathVariable("idPersona") Integer id,Model modelo) {
		
		Persona unaPersona=this.personaService.buscarPersonaIdService(id);
		modelo.addAttribute("personaUnica",unaPersona);
		return "vistaPersona";
	}
	
	@PutMapping("/actualizar/{idPersona}")
	public String actualizarPersona(@PathVariable("idPersona") Integer id, Persona  persona) {
		persona.setId(id);
		this.personaService.actualizarService(persona);
		
		return "redirect:/personas/buscar";
	}
	
	@DeleteMapping("/eliminar/{idPersona}")
	public String eliminarPersona(@PathVariable("idPersona") Integer id) {
		this.personaService.eliminarService(id);
		return "redirect:/personas/buscar";
	}
	
	@PostMapping("/insertar")
	public String insertarPersona(Persona persona) {
		this.personaService.insertarService(persona);
		return "redirect:/personas/buscar";
	}
	
	@GetMapping("/nuevaPersona")
	public String PaginaNuevaPersona(Persona persona) {
		return "vistaNuevaPersona";
	}
	
}
