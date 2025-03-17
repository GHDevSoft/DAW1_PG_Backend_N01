package com.centroinformacion.service;

import java.util.Date;
import java.util.List;

import com.centroinformacion.entity.Tesis;

public interface TesisService {	
		
	
	//Para el CRUD
	public abstract Tesis insertaActualizaTesis(Tesis obj);
	public abstract List<Tesis> listaTesisPorTituloLike(String titulo);
	public abstract void eliminaTesis(int idTesis);
	public abstract List<Tesis> listaTodos();	
	
	//Validaciones Para Registrar
	public abstract List<Tesis> listaTesisPorTituloIgualRegistra(String titulo);
	
	//Validaciones Para Actualizar
	public abstract List<Tesis> listaTesisPorTituloIgualActualiza(String titulo, int idTesis);
	
	//Para la Consulta
	public abstract List<Tesis> listaConsultaCompleja(String titulo, Date fecIni, Date fecFin, int estado, int idTema, int idIdioma, int idCentroEstudios);
		
}


