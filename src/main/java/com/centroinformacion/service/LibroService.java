package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import com.centroinformacion.entity.Autor;
import com.centroinformacion.entity.Libro;
import com.centroinformacion.entity.LibroHasAutor;
import com.centroinformacion.entity.LibroHasAutorPK;

public interface LibroService {
	//-------2)CRUD---
			//Para el crud
			public abstract Libro insertaActualizaLibro(Libro obj);
			public abstract List<Libro> listaLibroPorTituloLike(String titulo);
			public abstract void eliminaLibro(int idLibro);
			public abstract List<Libro> listaTodos();
			
			//Validaciones Para Revistrar
			public abstract List<Libro> listaLibroPorTituloIgualRegistra(String titulo);
			
			//Validaciones Para Actualizar
			public abstract List<Libro> listaLibroPorTituloIgualActualiza(String titulo,int idLibro);
			
			//Para la consulta
			public abstract List<Libro> listaConsultaCompleja(String titulo, int estado,int idPais,int idCategoria);
			
      //Prestamo
			public List<Libro> listaLibro(String filtro, Pageable pageable);
  
			//Asignación
			public abstract List<Autor> traerLibroDeAutor(int idLibro);
			
			public abstract LibroHasAutor insertaAutor (LibroHasAutor obj);
			public abstract void eliminaAutor(LibroHasAutor obj);
			public abstract Optional<LibroHasAutor> buscaAutor(LibroHasAutorPK obj);
}


