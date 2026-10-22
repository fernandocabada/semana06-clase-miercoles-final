package com.cibertec.semana04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.semana04.model.Editorial;
import com.cibertec.semana04.model.Libro;
import com.cibertec.semana04.model.Reporte;
import com.cibertec.semana04.repository.EditorialRepository;
import com.cibertec.semana04.repository.LibroRepository;

@Service
public class BibliotecaService {

	@Autowired
	private EditorialRepository editorialRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	
	public Editorial guardarEditorial(Editorial editorial) {
		return editorialRepository.save(editorial);
	}
	
	public List<Editorial> listarEditorial() {
		return editorialRepository.findAll();
	}
	
	public Optional<Editorial> buscarEditorialPorId(Long id) {
		return editorialRepository.findById(id);
	}
	
	public void eliminarEditorial(Long id) {
		editorialRepository.deleteById(id);
	}
	
	public Libro guardarLibro(Libro libro) {
		return libroRepository.save(libro);
	}
	
	public List<Libro> listarLibros() {
		return libroRepository.findAll();
	}
	
	public Optional<Libro> buscarLibroPorId(Long id) {
		return libroRepository.findById(id);
	}
	
	public List<Libro> listarLibrosPorEditorial(Long idEditorial) {
		return libroRepository.findByEditorialIdEditorial(idEditorial);
	}
	
	public void eliminarLibro(Long id) {
		libroRepository.deleteById(id);
	}
	
	public List<Reporte> contarLibroPorEditorial() {
		return libroRepository.contarLibroPorEditorial();
	}
	
}







