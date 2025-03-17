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

import com.centroinformacion.entity.Libro;
import com.centroinformacion.service.LibroService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/consultaLibro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroConsultaController {
	@Autowired
	private LibroService libroService;
	// CONSULTA
		@GetMapping("/consultaLibroPorParametros")
		@ResponseBody
		public ResponseEntity<?> consultaLibroPorParametros(
				@RequestParam(name = "titulo", required = true, defaultValue = "") String titulo,
				@RequestParam(name = "estado", required = true, defaultValue = "") int estado,
				@RequestParam(name = "idTipoLibro", required = false, defaultValue = "-1") int idPais,
				@RequestParam(name = "idCategoria", required = false, defaultValue = "-1") int idCategoria) {

			List<Libro> lstSalida = libroService.listaConsultaCompleja("%" + titulo + "%",estado,
					idPais, idCategoria);

			return ResponseEntity.ok(lstSalida);
		}
	}




























