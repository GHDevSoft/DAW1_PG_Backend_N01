package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Prestamo;
import com.centroinformacion.entity.PrestamoHasLibro;
import com.centroinformacion.repository.PrestamoHasLibroRepository;
import com.centroinformacion.repository.PrestamoRepository;

import jakarta.transaction.Transactional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

	@Autowired	
	private PrestamoRepository prestamoRepository ;
	
	@Autowired
	private PrestamoHasLibroRepository detalleRepository;

	@Override
	@Transactional
	public Prestamo insertaPrestamo(Prestamo obj) {
		Prestamo cabecera = prestamoRepository.save(obj);
		
		return cabecera;
	}
	
	@Override
	public List<Prestamo> listaPrestamo() {
		return prestamoRepository.findAll();
	}
	
}
