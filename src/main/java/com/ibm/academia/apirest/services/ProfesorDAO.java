package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Persona;

public interface ProfesorDAO extends PersonaDAO {
	public Iterable<Persona> findProfesoresByCarrera(String carrera);
	public Iterable<Persona> findProfesoresByCarreraContains(String carrera);
}