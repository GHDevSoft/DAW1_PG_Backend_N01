package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.entity.Libro;
import com.centroinformacion.service.LibroService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/libro") 
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroRegistraController {
    
    @Autowired 
    private LibroService libroService; 
    
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Libro>> listarLibro() {
        List<Libro> lista = libroService.listaTodos(); 
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping 
    @ResponseBody
    public ResponseEntity<?> insertar(@RequestBody Libro obj) {
        HashMap<String, Object> salida = new HashMap<>();
        
        Editorial editorialPredeterminada = new Editorial();
        editorialPredeterminada.setIdEditorial(1);
        
        obj.setFechaRegistro(new Date());
        obj.setFechaActualizacion(new Date());
        obj.setEstado(AppSettings.ACTIVO);
        obj.setEditorial(editorialPredeterminada);
        
        Libro objSalida = libroService.insertaActualizaLibro(obj); 
        
        if (objSalida == null) {
            salida.put("mensaje","Fallo en el registro");
        } else {
            salida.put("mensaje", "Se registró un nuevo libro: " + objSalida.getIdLibro());
        }
        
        return ResponseEntity.ok(salida);
    }
}