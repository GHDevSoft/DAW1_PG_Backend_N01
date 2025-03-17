package com.centroinformacion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.entity.LibroHasAutor;
import com.centroinformacion.entity.LibroHasAutorPK;
import com.centroinformacion.service.LibroService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/asignacionAutor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AutorController {

	@Autowired
	private LibroService libroService;
	
	@ResponseBody
	@GetMapping("/listaAutorPorLibro/{id}")
	public List<Autor> listaAutorPorLibro(@PathVariable("id")int idLibro){
		return libroService.traerLibroDeAutor(idLibro);
	}
	
	@ResponseBody
	@GetMapping("/registraAutor")
	public HashMap<String, Object> registro(
			@RequestParam(name = "idLibro" , defaultValue = "-1" , required = true)int idLibro, 
			@RequestParam(name = "idAutor" , defaultValue = "-1" , required = true)int idAutor){
		HashMap<String, Object> maps = new HashMap<String, Object>();
		LibroHasAutorPK pk = new LibroHasAutorPK();
		pk.setIdAutor(idAutor);
		pk.setIdLibro(idLibro);

		LibroHasAutor obj = new LibroHasAutor();
		obj.setLibroHasAutorPK(pk);
		
		Optional<LibroHasAutor> existentAutor = libroService.buscaAutor(pk);
        if (existentAutor.isEmpty()) {
        	LibroHasAutor objSalida = libroService.insertaAutor(obj);
        	if (objSalida == null) {
        		maps.put("mensaje", "Error en el registro");		
        	}else {
        		maps.put("mensaje", "Registro exitoso");
        	}
        }else {
        	maps.put("mensaje", "Ya existe el Autor");
        }
        List<Autor> lstAutor =  libroService.traerLibroDeAutor(idLibro);
        maps.put("lista", lstAutor);
		return maps;
	}
	
	@ResponseBody
	@GetMapping("/eliminaAutor")
	public HashMap<String, Object> elimina(
			@RequestParam(name = "idLibro" , defaultValue = "-1" , required = true)int idLibro, 
			@RequestParam(name = "idAutor" , defaultValue = "-1" , required = true)int idAutor){
		HashMap<String, Object> maps = new HashMap<String, Object>();
		
		LibroHasAutorPK pk = new LibroHasAutorPK();
		pk.setIdAutor(idAutor);
		pk.setIdLibro(idLibro);

		LibroHasAutor obj = new LibroHasAutor();
		obj.setLibroHasAutorPK(pk);
		
		libroService.eliminaAutor(obj);
		maps.put("mensaje", "Eliminación exitosa");
		
		List<Autor> lstPasatiempo =  libroService.traerLibroDeAutor(idLibro);
        maps.put("lista", lstPasatiempo);

		return maps;
	}
}
