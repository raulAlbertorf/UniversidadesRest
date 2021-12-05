package com.ibm.academia.apirest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Persona;

@Repository("repositorioProfesor")
public interface ProfesorRepository extends PersonaRepository {

	@Query("select p from Profesor p join p.carreras c where c.nombre = ?1")
	public Iterable<Persona> findProfesoresByCarrera(String carrera);
	
	@Query("select p from Profesor p join p.carreras c where c.nombre like %?1%")
	public Iterable<Persona> findProfesoresByCarreraContains(String carrera);

	

}
