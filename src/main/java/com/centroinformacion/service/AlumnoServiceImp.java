package com.centroinformacion.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<Alumno> listaTodos() {
		return repository.findByOrderByApellidosAsc();
	}

	@Override
	public Alumno insertaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public List<Alumno> listaAlumnoPorNombreLike(String nombre) {
		return repository.listaPorNombreLike(nombre);
	}

	@Override
	public void eliminaAlumno(int idAlumno) {
		repository.deleteById(idAlumno);
		
	}

	@Override
	public List<Alumno> listaAlumnoPorNombreIgualRegistra(String nombre) {
		return repository.listaPorNombreIgualRegistra(nombre);
	}

	@Override
	public List<Alumno> listaAlumnoPorNombreIgualActualiza(String nombre, int idAlumno) {
		return repository.listaPorNombreIgualActualiza(nombre, idAlumno);
	}

	@Override
	public List<Alumno> listaConsultaCompleja(String nom, String dni, int estado, Date fdesde, Date fhasta,
			int idPais) {
		return repository.listaConsultaCompleja(nom, dni, estado, fdesde, fhasta, idPais);
	}
	
	@Override
	public List<Alumno> listaAlumno(String filtro, Pageable ageable) {
		return repository.listaAlumno(filtro, ageable);
	}

	
}
