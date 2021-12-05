package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {

	//@Query("select a from Aula a join fetch a.pabellon p where a.pizarron = ?1")
	public Iterable<Aula> findAulasByPizarron(Pizarron pizarron);
	public Iterable<Aula> findAulasByPabellonNombre(String nombre);
	//@Query("select a from Aula a where a.numeroAula = ?1")
	public Aula findAulaByNumeroAula(Integer numeroAula);
		
}
