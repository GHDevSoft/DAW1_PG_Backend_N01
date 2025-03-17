package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

	//-------1)AGREGAR METODO PARA CRUD---------
	
		//JPQL ==> Java Persistence Query Language
		//JPQL ==> Query a nivel de clases
		@Query("select e from Libro e where e.titulo like ?1 ")
		public abstract List<Libro> listaPorTituloLike(String nombre);
		
		@Query("select e from Libro e where e.titulo = ?1 ")
		public abstract List<Libro> listaPorTituloIgualRegistra(String nombre);
		
		@Query("select e from Libro e where e.titulo = ?1 and e.idLibro != ?2 ")
		public abstract List<Libro> listaPorTituloIgualActualiza(String titulo, int idLibro);
		//EF
		@Query("select e from Libro e where e.titulo like ?1 and "
											+ "e.estado = ?2 and "
											+ "(?3= -1 or e.tipoLibro.idDataCatalogo= ?3)and "
											+ "(?4= -1 or e.categoriaLibro.idDataCatalogo= ?4)")
		
		public abstract List<Libro> listaConsultaCompleja(String titulo, int estado,int idPais,int idCategoria);
		
		//T3
		@Query("select e from Libro e where e.titulo like :var_fil")
		public abstract List<Libro> listaLibro(@Param("var_fil") String filtro, Pageable pageable);
  
		@Query("Select la.autor from LibroHasAutor la where la.libro.idLibro = ?1")
		public abstract List<Autor> traerAutorDeLibro(int idLibro);
	

}





