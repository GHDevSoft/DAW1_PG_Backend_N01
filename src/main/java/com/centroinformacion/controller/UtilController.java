package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.entity.Autor;
import com.centroinformacion.entity.DataCatalogo;
import com.centroinformacion.entity.Libro;
import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Pais;
import com.centroinformacion.entity.Rol;

import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.AlumnoService;
import com.centroinformacion.service.AutorService;
import com.centroinformacion.service.DataCatalogoService;
import com.centroinformacion.service.LibroService;
import com.centroinformacion.service.OpcionService;
import com.centroinformacion.service.PaisService;
import com.centroinformacion.service.RolService;
import com.centroinformacion.service.UsuarioService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private DataCatalogoService dataCatalogoService;
	
	@Autowired
	private AlumnoService alumnoService;
	
	//Transacción Asignación de Opción	
	@Autowired
	private OpcionService opcionService;	
	

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listaTodos();
	}
	
	@GetMapping("/listaAlumno")
	@ResponseBody
	public List<Alumno> listaAlumno() {
		return alumnoService.listaTodos();
	}

	@GetMapping("/listaCategoriaDeLibro")
	@ResponseBody
	public List<DataCatalogo> listaCategoriaDeLibro() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_01_CATEGORIA_DE_LIBRO);
	}
	
	@GetMapping("/listaTipoProveedor")
	@ResponseBody
	public List<DataCatalogo> listaTipoProveedor() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_02_TIPO_DE_PROVEEDOR);
	}
	
	@GetMapping("/listaModalidadAlumno")
	@ResponseBody
	public List<DataCatalogo> listaModalidadAlumno() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_03_MODALIDAD_DE_ALUMNO);
	}
	
	@GetMapping("/listaGradoAutor")
	@ResponseBody
	public List<DataCatalogo> listaGradoAutor() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_04_GRADO_DE_AUTOR);
	}	
	
	@GetMapping("/listaTipoLibroRevista")
	@ResponseBody
	public List<DataCatalogo> listaTipoLibroRevista() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_05_TIPO_DE_LIBRO_Y_REVISTA);
	}	
	
	@GetMapping("/listaTipoSala")
	@ResponseBody
	public List<DataCatalogo> listaTipoSala() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_06_TIPO_DE_SALA);
	}	
	
	@GetMapping("/listaSede")
	@ResponseBody
	public List<DataCatalogo> listaSede() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_07_SEDE);
	}	
	
	@GetMapping("/listaEstadoLibro")
	@ResponseBody
	public List<DataCatalogo> listaEstadoLibro() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_08_ESTADO_DE_LIBRO);
	}
	
	@GetMapping("/listaEstadoReserva")
	@ResponseBody
	public List<DataCatalogo> listaEstadoReserva(){
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_09_ESTADO_DE_RESERVA);
	}
		
	
	@GetMapping("/listaCentroEstudio")
	@ResponseBody
	public List<DataCatalogo> listaCentroEstudio() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_10_CENTRO_DE_ESTUDIOS);
	}
			
	@GetMapping("/listaIdioma")
	@ResponseBody
	public List<DataCatalogo> listaIdioma() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_11_IDIOMA);
	}
			
	@GetMapping("/listaTemaTesis")
	@ResponseBody
	public List<DataCatalogo> listaTemaTesis() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_12_TEMA_DE_TESIS);
	}	
	
	//Transacción Asignación de Opción
	@GetMapping("/listaOpcion")
	@ResponseBody
	public List<Opcion> listaOpcion() {
		return opcionService.listaOpcion();
	}  
	
	/*ASIGNACION ROL*/
	@Autowired
	private RolService rolService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listaRol")
	@ResponseBody
	public List<Rol> listaRol() {
		return rolService.listaRol();
	}
	
	@GetMapping("/listaUsuario")
	@ResponseBody
	public List<Usuario> listaUsuario() {
		return usuarioService.listaUsuario();
	}
	
	/*ASIGNACION AUTOR*/
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping("/listaLibro")
	@ResponseBody
	public List<Libro> listaLibro() {
		return libroService.listaTodos();
	}
	
	@GetMapping("/listaAutor")
	@ResponseBody
	public List<Autor> listaAutor() {
		return autorService.listaAutor();
	}
	
}
	

