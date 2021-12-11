package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;

@DataJpaTest
public class ProfesorRepositoryTest {

	@Autowired
	@Qualifier("repositorioProfesor")
	private PersonaRepository profesorRepository;

	@Autowired
	private CarreraRepository carreraRrepository;

	@Test
	@DisplayName("Test: Bucar profesores por nombre de carrera")
	void findProfesoresByCarrera() {
		// Given
		Iterable<Persona> profesores = profesorRepository
				.saveAll(Arrays.asList(DatosDummy.profesor01(), DatosDummy.profesor02()));
		Iterable<Carrera> carreras = carreraRrepository
				.saveAll(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera02(), DatosDummy.carrera03()));

		Set<Carrera> setCarrera = new HashSet<>();
		carreras.forEach(carrera -> setCarrera.add(carrera));

		profesores.forEach(profesor -> ((Profesor) profesor).setCarreras(setCarrera));
		profesorRepository.saveAll(profesores);

		// When
		String nombreCarrera = "Licenciatura en Sistemas";
		Iterable<Persona> expected = ((ProfesorRepository) profesorRepository).findProfesoresByCarrera(nombreCarrera);

		// Then
		assertThat(((List<Persona>) expected).size()).isEqualTo(2);
	}

	@Test
	@DisplayName("Test: Bucar profesores por nombre de carrera contenida")
	void findProfesoresByCarreraContains() {
		// Given
		Iterable<Persona> profesores = profesorRepository
				.saveAll(Arrays.asList(DatosDummy.profesor01(), DatosDummy.profesor02()));
		Iterable<Carrera> carreras = carreraRrepository
				.saveAll(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera02(), DatosDummy.carrera03()));

		Set<Carrera> setCarrera = new HashSet<>();
		carreras.forEach(carrera -> setCarrera.add(carrera));

		profesores.forEach(profesor -> ((Profesor) profesor).setCarreras(setCarrera));
		profesorRepository.saveAll(profesores);

		// When
		String nombreCarrera = "Sistemas";
		Iterable<Persona> expected = ((ProfesorRepository) profesorRepository)
				.findProfesoresByCarreraContains(nombreCarrera);

		// Then
		assertThat(((List<Persona>) expected).size() == 4).isTrue();

	}

}
