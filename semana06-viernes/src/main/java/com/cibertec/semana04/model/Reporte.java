package com.cibertec.semana04.model;

public class Reporte {

	private Long idEditorial;
	private String nombreEditorial; 
	private Long cantidadLibros;
	
	public Reporte(Long idEditorial, String nombreEditorial, Long cantidadLibros) {
		super();
		this.idEditorial = idEditorial;
		this.nombreEditorial = nombreEditorial;
		this.cantidadLibros = cantidadLibros;
	}

	public Long getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Long idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}

	public Long getCantidadLibros() {
		return cantidadLibros;
	}

	public void setCantidadLibros(Long cantidadLibros) {
		this.cantidadLibros = cantidadLibros;
	}
	
	
	
}
