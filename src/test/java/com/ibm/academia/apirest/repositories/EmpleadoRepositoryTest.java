package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.models.entities.Persona;


@DataJpaTest
public class EmpleadoRepositoryTest {

	@Autowired
	@Qualifier("repositorioEmpleado")
	private PersonaRepository empleadoRepository;
	
	@Test
	@DisplayName("Test: Bucar empleado por tipo de empledo")
	void findEmpleadoByTipoEmpleado() {
		//Given
		Iterable<Persona> empleados = empleadoRepository.saveAll(
				Arrays.asList(
						DatosDummy.empleado01(),
						DatosDummy.empleado02(),
						DatosDummy.empleado03()
				));
		
		//when
		Iterable<Persona> expected = ((EmpleadoRepository)empleadoRepository).findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
		
		//Then
		assertThat(((List<Persona>)expected).size()).isEqualTo(2);
		
	}
	
}
