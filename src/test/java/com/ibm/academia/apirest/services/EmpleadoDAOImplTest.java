package com.ibm.academia.apirest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Empleado;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.EmpleadoRepository;

public class EmpleadoDAOImplTest {

	EmpleadoDAO empleadoDAO;
	EmpleadoRepository empleadoRepository;
	
	@BeforeEach
	void setUp() {
		empleadoRepository = mock(EmpleadoRepository.class);
		empleadoDAO = new EmpleadoDAOImpl(empleadoRepository);
	}
	
	@Test
	@DisplayName("Test: Busca empleado por tipo de empleado")
	void findEmpleadoByTipoEmpleado(){
		TipoEmpleado tipoEmpleado = TipoEmpleado.ADMINISTRATIVO;
		when((List<Persona>)empleadoRepository.findEmpleadoByTipoEmpleado(tipoEmpleado))
				.thenReturn(Arrays.asList(DatosDummy.empleado01()));

		// When
		List<Persona> expected = (List<Persona>) empleadoDAO.findEmpleadoByTipoEmpleado(tipoEmpleado);

		// Then
		assertThat(expected.size()).isEqualTo(1);
		assertThat(expected.get(0)).isEqualTo(DatosDummy.empleado01());
		assertThat(expected.get(0)).isInstanceOf(Empleado.class);

		verify(empleadoRepository).findEmpleadoByTipoEmpleado(tipoEmpleado);
	}
	
	
}
