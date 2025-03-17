package com.centroinformacion.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.service.AlumnoService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/consultaAlumno")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AlumnoConsultaController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/consultaAlumnoPorParametros")
	@ResponseBody
	public ResponseEntity<?> consultaAlumno(
						@RequestParam(name = "nombres" , required = true , defaultValue = "") String nom, 
						@RequestParam(name = "dni" , required = true , defaultValue = "") String dni,
						@RequestParam(name = "estado" , required = true , defaultValue = "")int estado, 
						@RequestParam(name = "fecDesde" , required = true , defaultValue = "")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fdesde, 
						@RequestParam(name = "fecHasta" , required = true , defaultValue = "")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fhasta, 
						@RequestParam(name = "idPais" , required = false , defaultValue = "-1")int idPais){
		List<Alumno> lstSalida = alumnoService.listaConsultaCompleja("%"+nom+"%", "%"+dni+"%", estado, fdesde, fhasta, idPais);
		
		return ResponseEntity.ok(lstSalida);
	}

}
