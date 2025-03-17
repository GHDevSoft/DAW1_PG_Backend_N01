package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.service.ProveedorService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/consultaProveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorConsultaController {

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/consultaProveedorPorParametros")
	@ResponseBody
	public ResponseEntity<?> consultaProveedor(
						@RequestParam(name = "razonsocial" , required = true , defaultValue = "") String raz, 
						@RequestParam(name = "ruc" , required = true , defaultValue = "") String ruc,
						@RequestParam(name = "estado" , required = true , defaultValue = "")int estado, 
						@RequestParam(name = "celular" , required = true , defaultValue = "")String cel, 
						@RequestParam(name = "contacto" , required = true , defaultValue = "")String con, 
						@RequestParam(name = "idPais" , required = false , defaultValue = "-1")int idPais, 
						@RequestParam(name = "idTipo" , required = false , defaultValue = "-1")int idTipo){
		List<Proveedor> lstSalida = proveedorService.listaConsultaCompleja("%"+raz+"%","%"+ruc+"%", estado,"%"+cel+"%","%"+con+"%", idPais, idTipo);
		
		return ResponseEntity.ok(lstSalida);
	}
}