package com.centroinformacion.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	public abstract List<Alumno> findByOrderByApellidosAsc();
	
	@Query("select a from Alumno a where a.nombres like ?1 ")
	public abstract List<Alumno> listaPorNombreLike(String nombre);
	
	@Query("select a from Alumno a where a.nombres = ?1 ")
	public abstract List<Alumno> listaPorNombreIgualRegistra(String nombre);
	
	@Query("select a from Alumno a where a.nombres = ?1 and a.idAlumno != ?2 ")
	public abstract List<Alumno> listaPorNombreIgualActualiza(String nombre, int idAlumno);
	
	@Query("select a from Alumno a where a.nombres like ?1 and "
			  + "a.dni like ?2 and "
			  + "a.estado = ?3 and "
			  + "a.fechaNacimiento >= ?4 and "
			  + "a.fechaNacimiento <= ?5 and "
			  + "(?6 = -1 or a.pais.idPais = ?6)")
	public abstract List<Alumno> listaConsultaCompleja(String nom, String dni, int estado, Date fdesde, Date fhasta, int idPais);
	
	@Query("Select a from Alumno a where a.nombres like :var_filtro or a.apellidos like :var_filtro")
	public abstract List<Alumno> listaAlumno(@Param("var_filtro") String filtro, Pageable ageable);
}
