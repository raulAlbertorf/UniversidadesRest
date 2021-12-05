package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.repositories.PabellonRepository;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {

	@Autowired
	public PabellonDAOImpl(PabellonRepository repository) {
		super(repository);
	}

	@Override
	public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad) {
		// TODO Auto-generated method stub
		return repository.findPabellonesByDireccionLocalidad(localidad);
	}

	@Override
	public Iterable<Pabellon> findPabellonesByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.findPabellonesByNombre(nombre);
	}

	

}
