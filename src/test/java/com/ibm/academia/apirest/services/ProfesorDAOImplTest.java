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
import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.repositories.ProfesorRepository;

public class ProfesorDAOImplTest {
	
	ProfesorDAO profesorDAO;
	ProfesorRepository profesorRepository;
	
	@BeforeEach
	void setUp() {
		profesorRepository = mock(ProfesorRepository.class);
		profesorDAO = new ProfesorDAOImpl(profesorRepository);
	}
	
	@Test
	@DisplayName("Test: Busca profesores por nombre de carrea")
	void findProfesoresByCarrera() {
		String nombreCarrera = "Ingenieria Industria";
		when((List<Persona>)profesorRepository.findProfesoresByCarrera(nombreCarrera))
				.thenReturn(Arrays.asList(DatosDummy.profesor03()));

		// When
		List<Persona> expected = (List<Persona>)profesorDAO.findProfesoresByCarrera(nombreCarrera);

		// Then
		assertThat(expected.size()).isEqualTo(1);
		assertThat(expected.get(0)).isInstanceOf(Profesor.class);

		verify(profesorRepository).findProfesoresByCarrera(nombreCarrera);
	}
	
	void findProfesoresByCarreraContains() {
		String nombreCarrera = "Ingenieria";
		when((List<Persona>)profesorRepository.findProfesoresByCarreraContains(nombreCarrera))
				.thenReturn(Arrays.asList(DatosDummy.profesor03(),DatosDummy.profesor03()));

		// When
		List<Persona> expected = (List<Persona>)profesorDAO.findProfesoresByCarreraContains(nombreCarrera);

		// Then
		assertThat(expected.size()).isEqualTo(2);
		assertThat(expected.get(0)).isInstanceOf(Profesor.class);
		
		verify(profesorRepository).findProfesoresByCarreraContains(nombreCarrera);
	}

}
