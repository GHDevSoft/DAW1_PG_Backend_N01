package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;
	
	
	@Override
	public Proveedor insertaActualizaProveedor(Proveedor obj) {
		return repository.save(obj);
	}
	@Override
	public List<Proveedor> listaTodos() {
		return repository.findAll();
	}

	@Override
	public List<Proveedor> listaProveedorPorNombreLike(String razonsocial) {
		
		return repository.listaPorNombreLike(razonsocial);
	}

	@Override
	public void eliminaProveedor(int idProveedor) {
		repository.deleteById(idProveedor);

		
	}

	@Override
	public List<Proveedor> listaProveedorPorNombreIgualRegistra(String razonsocial) {
		return repository.listaPorNombreIgualRegistra(razonsocial);

	}

	@Override
	public List<Proveedor> listaProveedorPorRazonSocialIgualActualiza(String razonsocial, int idProveedor) {
		return repository.listaPorNombreIgualActualiza(razonsocial, idProveedor);
	}
	@Override
	public List<Proveedor> listaConsultaCompleja(String raz, String ruc, int estado, String cel, String con, int idpais,
			int idTipo) {
		return repository.listaConsultaCompleja(raz, ruc, estado, cel, con, idpais, idTipo);
	}

}
