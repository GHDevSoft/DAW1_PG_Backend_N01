package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Sala;
import com.centroinformacion.repository.SalaRepository;

@Service
public class SalaServiceImp implements SalaService{

	@Autowired
	private SalaRepository repository;
	
	@Override
	public Sala insertaActualizaSala(Sala obj) {
		return repository.save(obj);
	}

	@Override
	public List<Sala> listaSala() {
		return repository.findAll();
	}

	@Override
	public List<Sala> listaSalaPorNumeroLike(String numero) {
		return repository.listaPorNumeroLike(numero);
	}

	@Override
	public void eliminaSala(int idSala) {
		repository.deleteById(idSala);
	}

	@Override
	public List<Sala> listaSalaPorNumeroIgualRegistra(String numero) {
		return repository.listaPorNumeroIgualRegistra(numero);
	}

	@Override
	public List<Sala> listaSalaPorNumeroIgualActualiza(String numero, int idSala) {
		return repository.listaPorNumeroIgualActualiza(numero, idSala);
	}

	@Override
	public List<Sala> listaConsultaCompleja(String numero, int estado, int idTipoSala, int idSede, int idEstadoReserva) {
		return repository.listaConsultaCompleja(numero, estado, idTipoSala, idSede, idEstadoReserva);
	}
	
	
	
	

}
