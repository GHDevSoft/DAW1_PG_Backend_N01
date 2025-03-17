package com.centroinformacion.service;


import java.util.List;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorService {
	
	public abstract List<Proveedor> listaProveedorPorNombreLike(String nombre);
	public abstract Proveedor insertaActualizaProveedor(Proveedor obj);
	public abstract void eliminaProveedor(int idProveedor);
	public abstract List<Proveedor> listaTodos();
	
	public abstract List<Proveedor> listaProveedorPorNombreIgualRegistra(String razonsocial);
	
	public abstract List<Proveedor> listaProveedorPorRazonSocialIgualActualiza(String razonsocial, int idProveedor);
	
	public abstract List<Proveedor> listaConsultaCompleja(String raz, String ruc,int estado,String cel, String con,int idpais,int idTipo);
}
