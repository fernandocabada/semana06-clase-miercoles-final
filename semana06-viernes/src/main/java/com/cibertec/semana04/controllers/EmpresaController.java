package com.cibertec.semana04.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.semana04.model.Empresa;
import com.cibertec.semana04.service.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/empresas")
	public String getAllEmpresas(Model model) {
		List<Empresa> listEmpresas = empresaService.getAllEmpresas();
		model.addAttribute("empresas", listEmpresas);
		System.out.println("EMPRESASSSS: " +listEmpresas.size());
		return "empresaList";
	}
	
	@GetMapping("/register")
	public String register() {
		return "empresaRegister";
	}
	
	@PostMapping("/register")
	public String createEmpresa(@RequestParam("name") String name, 
			Model model) {
		Empresa empresa = new Empresa();
		empresa.nombre = name;
		
		empresaService.createEmpresa(empresa);
		
		List<Empresa> listEmpresas = empresaService.getAllEmpresas();
		model.addAttribute("empresas", listEmpresas);
		
		return "redirect:empresas";
		// return "empresaList";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Empresa empresa = empresaService.getEmpresaById(id);
		model.addAttribute("empresa", empresa);
		return "empresaEdit";
	}
	
	@PostMapping("/edit")
	public String editEmpresa(@RequestParam("id") Long id, @RequestParam("name") String name,
			Model model) {
		
		Empresa empresa = empresaService.getEmpresaById(id);
		empresa.nombre = name;
		
		empresaService.createEmpresa(empresa);
		
		List<Empresa> listEmpresas = empresaService.getAllEmpresas();
		model.addAttribute("empresas", listEmpresas);
		return "empresaList";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		
		empresaService.deleteEmpresa(id);
		
		List<Empresa> listEmpresas = empresaService.getAllEmpresas();
		model.addAttribute("empresas", listEmpresas);
		
		return "productList";
	}
	
	
}











