package com.centroinformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.PrestamoHasLibro;
import com.centroinformacion.entity.PrestamoHasLibroPK;

public interface PrestamoHasLibroRepository extends JpaRepository<PrestamoHasLibro, PrestamoHasLibroPK> {

	
}
