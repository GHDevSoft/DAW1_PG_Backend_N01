package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<Autor> listaAutor() {
		return autorRepository.findAll();
	}

}
