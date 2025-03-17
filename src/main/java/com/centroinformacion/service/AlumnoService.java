package com.centroinformacion.service;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

import com.centroinformacion.entity.Alumno;

public interface AlumnoService {
	
	//Para el crud
	public abstract Alumno insertaAlumno(Alumno obj);
	public abstract List<Alumno> listaAlumnoPorNombreLike(String nombre);
	public abstract void eliminaAlumno(int idAlumno);
	public abstract List<Alumno> listaTodos();
			
	//Validaciones Para Revistrar
	public abstract List<Alumno> listaAlumnoPorNombreIgualRegistra(String nombre);
			
	//Validaciones Para Actualizar
	public abstract List<Alumno> listaAlumnoPorNombreIgualActualiza(String nombre, int idAlumno);
	
	public abstract List<Alumno> listaConsultaCompleja(String nom, String dni, int estado, Date fdesde, Date fhasta, int idPais);
	
	//Lista alumnos
	public abstract List<Alumno> listaAlumno(String filtro, Pageable ageable) ;

}
