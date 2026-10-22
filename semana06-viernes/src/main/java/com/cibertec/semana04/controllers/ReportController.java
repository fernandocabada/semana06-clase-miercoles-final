package com.cibertec.semana04.controllers;

import com.cibertec.semana04.Semana04Application;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.semana04.model.Libro;
import com.cibertec.semana04.model.Reporte;
import com.cibertec.semana04.service.BibliotecaService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/report")
public class ReportController {

	private final Semana04Application semana04Application;
	@Autowired
	private BibliotecaService bibliotecaService;

	ReportController(Semana04Application semana04Application) {
		this.semana04Application = semana04Application;
	}
	
	@GetMapping("/reportBook")
	public void report(HttpServletResponse response) throws JRException, IOException {
		
		InputStream jasStream = this.getClass().getResourceAsStream("/reportes/report_books.jasper");
		
		Map<String, Object> params = new HashMap<>();
		params.put("usuario", "Jorge Ventura");
		
		List<Libro> listLibros = bibliotecaService.listarLibros();
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listLibros);
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "filename=reporte_libros.pdf");
		
		final OutputStream outputStream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		
	}
	
	@GetMapping("/reportIndicador")
	public void reportIndicador(HttpServletResponse response) throws JRException, IOException {
		
		InputStream jasStream = this.getClass().getResourceAsStream("/reportes/reporte_indicador.jasper");
		
		Map<String, Object> params = new HashMap<>();
		params.put("usuario", "Jorge Ventura");
		
		List<Reporte> listLibros = bibliotecaService.contarLibroPorEditorial();
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listLibros);
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "filename=reporte_indicador.pdf");
		
		final OutputStream outputStream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		
	}
	
}













