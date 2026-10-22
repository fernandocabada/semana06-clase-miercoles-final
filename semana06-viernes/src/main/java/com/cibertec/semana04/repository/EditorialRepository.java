package com.cibertec.semana04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.semana04.model.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

}
