package com.cibertec.semana04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.semana04.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
}
