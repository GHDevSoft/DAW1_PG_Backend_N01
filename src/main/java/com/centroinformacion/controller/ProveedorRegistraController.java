package com.centroinformacion.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.service.ProveedorService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorRegistraController {
	@Autowired
	private ProveedorService proveedorService;

	
	@GetMapping
	public List<Proveedor> listaProveedores(){
		List<Proveedor> lstSalida = proveedorService.listaTodos();
		return lstSalida;
	}
	
	@PostMapping

	public ResponseEntity<?> inserta(@RequestBody Proveedor obj){
		List<String> salida = new ArrayList<String>();
		
		obj.setFechaActualizacion(new Date());
		obj.setFechaRegistro(new Date());
		obj.setEstado(AppSettings.ACTIVO);
		
		
		Proveedor objSalida = proveedorService.insertaActualizaProveedor(obj);
		if (objSalida == null) {
			salida.add("Error en el registro");
		}else {
			salida.add("Se registró el Proveedor con el ID ==> " + objSalida.getIdProveedor());
		}
		return ResponseEntity.ok(salida);
	}

}
