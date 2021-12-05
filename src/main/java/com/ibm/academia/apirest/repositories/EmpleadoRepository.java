package com.ibm.academia.apirest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.TipoEmpleado;

@Repository("repositorioEmpleado")
public interface EmpleadoRepository extends PersonaRepository {
	
	@Query("select p from Persona p where p.tipoEmpleado = ?1")
	Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}
