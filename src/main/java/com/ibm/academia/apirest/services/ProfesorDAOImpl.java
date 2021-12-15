package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import com.ibm.academia.apirest.repositories.ProfesorRepository;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {

	@Autowired
	public ProfesorDAOImpl(@Qualifier("repositorioProfesor") PersonaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findProfesoresByCarrera(String carrera) {
		// TODO Auto-generated method stub
		return ((ProfesorRepository) repository).findProfesoresByCarrera(carrera);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findProfesoresByCarreraContains(String carrera) {
		// TODO Auto-generated method stub
		return ((ProfesorRepository) repository).findProfesoresByCarreraContains(carrera);
	}

}
