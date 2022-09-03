package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
