package com.cibertec.semana04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.semana04.model.Empresa;
import com.cibertec.semana04.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> getAllEmpresas() {
		return empresaRepository.findAll();
	}
	
	public Empresa getEmpresaById(Long id) {
		return empresaRepository.findById(id).orElse(null);
	}
	
	public Empresa createEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public void deleteEmpresa(Long id) {
		empresaRepository.deleteById(id);
	}
	
	
}
