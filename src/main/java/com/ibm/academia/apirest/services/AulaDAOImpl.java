package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.repositories.AulaRepository;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {

	@Autowired
	public AulaDAOImpl(AulaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional
	public Iterable<Aula> findAulasByPizarron(Pizarron pizarron) {
		return repository.findAulasByPizarron(pizarron);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulasByPabellonNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.findAulasByPabellonNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Aula findAulaByNumeroAula(Integer numeroAula) {
		// TODO Auto-generated method stub
		return repository.findAulaByNumeroAula(numeroAula);
	}

}
