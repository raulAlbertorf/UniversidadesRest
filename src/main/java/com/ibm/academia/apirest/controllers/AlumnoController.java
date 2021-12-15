package com.ibm.academia.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	@Qualifier("alumnoDAOImpl")
	private PersonaDAO alumnoDAO;
	
	@Autowired
	private CarreraDAO carreraDao;
	
	/**
	 * Endpoint para crear Persona de tipo Alumno
	 * @param alumno Objeto a guardar
	 * @return Retorna objeto Persona de tipo Alumno con codigo httpstatus 201
	 * @author RaulRF - 13/12/2021
	 */
	@PostMapping
	public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno){
		Persona personaGuardada = alumnoDAO.guardar(alumno);		
		return new ResponseEntity<Persona>(personaGuardada, HttpStatus.CREATED);	
	}
	
	/**
	 * Endpoint para buscar todas las personas de tipo Alumno
	 * @return Lista con todos los objetos Persona de tipo Alumno
	 * @NotFoundException En caso de no existir alumnos
	 * @author RaulRF - 13/12/2021
	 */
	@GetMapping("/lista/alumnos")
	public ResponseEntity<?> buscarTodos(){
		List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();
		if(alumnos.isEmpty()) {
			throw new NotFoundException("No existen alumno");
		}
		
		return new ResponseEntity<List<Persona>>(alumnos, HttpStatus.OK);
	}
	
	@GetMapping("/alumnoId/{alumnoId}")
	public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer alumnoId){
		Optional<Persona> alumno = alumnoDAO.buscarPorId(alumnoId);
		if(!alumno.isPresent()) {
			throw new NotFoundException(String.format("No existe alumno con Id: %d", alumnoId));
		}
		
		return new ResponseEntity<Persona>(alumno.get(), HttpStatus.OK);
	}
	
	
	@PutMapping("/upd/alumnoId/{alumnoId}")
	public ResponseEntity<?> actualizarCarrera(@PathVariable Integer alumnoId, @RequestBody Persona alumno){
		Optional<Persona> oPersona = alumnoDAO.buscarPorId(alumnoId);
		
		if(!oPersona.isPresent()) {
			throw new NotFoundException(String.format("El alumno con Id: %d no existe", alumnoId));
		}
		
		Persona alumnoActualizado = ((AlumnoDAO)alumnoDAO).actualizar(oPersona.get(), alumno);
		
		return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/alumnoId/{alumnoId}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Integer alumnoId){
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);
		
		if(!oAlumno.isPresent()) {
			throw new NotFoundException(String.format("El alumno con Id: %d no existe", alumnoId));
		}
		
		alumnoDAO.eliminarPorId(alumnoId);
		respuesta.put("OK", "Alumno ID: "+alumnoId+" eliminado exitosamente");
		return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/alumnoId/{alumnoId}/carreraId/{carreraId}")
	public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId, @PathVariable Integer alumnoId){
		Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);
		if(!oAlumno.isPresent()) {
			throw new NotFoundException(String.format("El alumno con Id: %d no existe", alumnoId));
		}
		
		Optional<Carrera> oCarrera = carreraDao.buscarPorId(carreraId);
		
		if(!oCarrera.isPresent()) {
			throw new NotFoundException(String.format("La carrera con Id: %d no existe", carreraId));
		}
		
		Persona alumno = ((AlumnoDAO)alumnoDAO).asociarCarreraAlumno(oAlumno.get(),oCarrera.get());
		
		return new ResponseEntity<Persona>(alumno, HttpStatus.OK);
	}
	
	

}
