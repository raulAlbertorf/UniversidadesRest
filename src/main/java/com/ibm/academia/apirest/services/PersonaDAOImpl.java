package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {

	public PersonaDAOImpl(PersonaRepository repository) {
		super(repository);
	}

	@Override
	public Optional<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return repository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public Optional<Persona> buscarPorDni(String dni) {
		// TODO Auto-generated method stub
		return repository.buscarPorDni(dni);
	}

	@Override
	public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return repository.buscarPersonaPorApellido(apellido);
	}

}
