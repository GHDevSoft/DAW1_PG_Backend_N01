package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>{
	
	@Query("select e from Sala e where e.numero like ?1 ")
	public abstract List<Sala> listaPorNumeroLike(String numero);
	
	@Query("select e from Sala e where e.numero = ?1 ")
	public abstract List<Sala> listaPorNumeroIgualRegistra(String numero);
	
	@Query("select e from Sala e where e.numero = ?1 and e.idSala != ?2 ")
	public abstract List<Sala> listaPorNumeroIgualActualiza(String numero, int idSala);
	
	@Query("select e from Sala e where e.numero like ?1 and "
									+ "e.estado = ?2 and "
									+ "(?3 = -1 or e.tipoSala.idDataCatalogo = ?3) and "
									+ "(?4 = -1 or e.sede.idDataCatalogo = ?4) and "
									+ "(?5 = -1 or e.estadoReserva.idDataCatalogo = ?5) ")
	public abstract List<Sala> listaConsultaCompleja(String numero, int estado, int idTipoSala, int idSede, int idEstadoReserva);

}
