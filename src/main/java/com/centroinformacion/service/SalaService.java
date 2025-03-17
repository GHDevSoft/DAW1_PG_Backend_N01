package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Sala;

public interface SalaService {
	
	public abstract List<Sala> listaSala();
	
	//Para el CRUD
	public abstract Sala insertaActualizaSala(Sala obj);
	public abstract List<Sala> listaSalaPorNumeroLike(String numero);
	public abstract void eliminaSala(int idSala);
	
	//Validaciones Para Registrar
	public abstract List<Sala> listaSalaPorNumeroIgualRegistra(String numero);
	
	//Validaciones Para Actualizar
	public abstract List<Sala> listaSalaPorNumeroIgualActualiza(String numero, int idSala);
	
	//Consultas
	public abstract List<Sala> listaConsultaCompleja(String numero, int estado, int idTipoSala, int idSede, int idEstadoReserva);
}
