package com.cibertec.semana04.controllers;

import com.cibertec.semana04.repository.EditorialRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.semana04.model.Libro;
import com.cibertec.semana04.service.BibliotecaService;

@Controller
@RequestMapping("/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaService bibliotecaService;

	@GetMapping("/libros")
	public String listarLibros(Model model) {
		List<Libro> libros = bibliotecaService.listarLibros();
		model.addAttribute("libros", libros);
		return "libroList"; // Vista para listar los libros
	}
	
}
