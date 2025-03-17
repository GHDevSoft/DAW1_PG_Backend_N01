package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	@Query("select e from Proveedor e where e.razonsocial like ?1 ")
	public abstract List<Proveedor> listaPorNombreLike(String razonsocial);
	
	@Query("select e from Proveedor e where e.razonsocial = ?1 ")
	public abstract List<Proveedor> listaPorNombreIgualRegistra(String razonsocial);
	
	@Query("select e from Proveedor e where e.razonsocial = ?1 and e.idProveedor != ?2 ")
	public abstract List<Proveedor> listaPorNombreIgualActualiza(String razonsocial, int idProveedor);
	
	@Query("select e from Proveedor e where e.razonsocial like ?1 and "
										+"e.ruc like ?2 and "
										+"e.estado = ?3 and "
										+"e.celular like ?4 and "
										+"e.contacto like ?5 and "
										+"(?6 = -1 or e.pais.idPais = ?6) and "
										+"(?7 = -1 or e.tipoProveedor.idDataCatalogo = ?7)")
	public abstract List<Proveedor> listaConsultaCompleja(String raz, String ruc,int estado,String cel, String con,int idpais,int idTipo);
}
