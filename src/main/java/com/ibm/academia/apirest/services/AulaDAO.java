package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.models.entities.Aula;

public interface AulaDAO extends GenericoDAO<Aula> {
	public Iterable<Aula> findAulasByPizarron(Pizarron pizarron);
	public Iterable<Aula> findAulasByPabellonNombre(String nombre);
	public Aula findAulaByNumeroAula(Integer numeroAula);
}
