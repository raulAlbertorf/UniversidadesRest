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
import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.AlumnoRepository;

public class AlumnoDAOImplTest {
	
	AlumnoDAO alumnoDAO;
	AlumnoRepository alumnoRepository;
	
	@BeforeEach
	void setUp() {
		alumnoRepository = mock(AlumnoRepository.class);
		alumnoDAO = new AlumnoDAOImpl(alumnoRepository);
	}
	
	@Test
	@DisplayName("Test: Busca alumno por nombre de su carrera")
	void buscarAlumnoPorNombreCarrera() {
		String nombre = "Ingenieria Industria";
		when((List<Persona>)alumnoRepository.buscarAlumnoPorNombreCarrera(nombre))
				.thenReturn(Arrays.asList(DatosDummy.alumno04()));

		// When
		List<Persona> expected = (List<Persona>)alumnoDAO.buscarAlumnoPorNombreCarrera(nombre);

		// Then
		assertThat(expected.size()).isEqualTo(1);
		assertThat(((Alumno)expected.get(0)).getCarrera()).isEqualTo(DatosDummy.carrera03());

		verify(alumnoRepository).buscarAlumnoPorNombreCarrera(nombre);
	}
}
