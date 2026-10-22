package com.cibertec.semana04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cibertec.semana04.model.Libro;
import com.cibertec.semana04.model.Reporte;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

	List<Libro> findByEditorialIdEditorial(Long idEditorial);
	
	@Query("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo ESCAPE '\\'")
	List<Libro> findByTituloContaining(String titulo);
	
	@Query("SELECT Reporte(e.idEditorial, e.nombre, COUNT(li)) "
			+ "FROM Libro li JOIN li.editorial e GROUP BY e.idEditorial, e.nombre")
	List<Reporte> contarLibroPorEditorial();
}
