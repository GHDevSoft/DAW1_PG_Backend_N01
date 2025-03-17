package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.entity.Libro;
import com.centroinformacion.entity.LibroHasAutor;
import com.centroinformacion.entity.LibroHasAutorPK;
import com.centroinformacion.repository.LibroHasAutorRepository;
import com.centroinformacion.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	private LibroRepository repository;

	@Autowired
	private LibroHasAutorRepository libroHasAutorRepository;
	
	@Override
	public Libro insertaActualizaLibro(Libro obj) {
		return repository.save(obj);
	}
	@Override
	public List<Libro> listaTodos() {
		return repository.findAll();
	}
	@Override
	public List<Libro> listaLibroPorTituloLike(String titulo) {
		return repository.listaPorTituloLike(titulo);
	}
	@Override
	public void eliminaLibro(int idLibro) {
		repository.deleteById(idLibro);
	}
	@Override
	public List<Libro> listaLibroPorTituloIgualRegistra(String titulo) {
		return repository.listaPorTituloIgualRegistra(titulo);
	}
	@Override
	public List<Libro> listaLibroPorTituloIgualActualiza(String titulo, int idLibro) {
		return repository.listaPorTituloIgualActualiza(titulo, idLibro);
	}
	@Override
	public List<Libro> listaConsultaCompleja(String titulo, int estado, int idPais, int idCategoria) {
		// TODO Auto-generated method stub
		return repository.listaConsultaCompleja(titulo, estado, idPais, idCategoria);
	}
	@Override
	public List<Autor> traerLibroDeAutor(int idLibro) {
		return repository.traerAutorDeLibro(idLibro);
	}
	@Override
	public LibroHasAutor insertaAutor(LibroHasAutor obj) {
		return libroHasAutorRepository.save(obj);
	}
	@Override
	public void eliminaAutor(LibroHasAutor obj) {
		libroHasAutorRepository.delete(obj);
	}
	@Override
	public Optional<LibroHasAutor> buscaAutor(LibroHasAutorPK obj) {
		return libroHasAutorRepository.findById(obj);
	}
	
	@Override
	public List<Libro> listaLibro(String filtro, Pageable pageable) {
		return repository.listaLibro(filtro, pageable);
	}
	
}