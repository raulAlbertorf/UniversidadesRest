package com.ibm.academia.apirest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.util.Optionals;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.repositories.PersonaRepository;

public class PersonaDAOImplTest {

	PersonaDAO personaDAO;
	PersonaRepository personaRepository;

	@BeforeEach
	void setUp() {
		personaRepository = mock(PersonaRepository.class);
		personaDAO = new PersonaDAOImpl(personaRepository);
	}

	@Test
	@DisplayName("Test: Buscar persona por nombre y apellido")
	void buscarPorNombreApellido() {
		// Given
		String nombre = "ANombre 01";
		String apellido = "AApellido 01";
		when(personaRepository.buscarPorNombreApellido(nombre, apellido))
				.thenReturn(Optional.of(DatosDummy.alumno01()));

		// When
		Optional<Persona> expected = personaDAO.buscarPorNombreApellido(nombre, apellido);

		// Then
		assertThat(expected.get().getNombre()).isEqualTo(nombre);
		assertThat(expected.get().getApellido()).isEqualTo(apellido);

		verify(personaRepository).buscarPorNombreApellido(nombre, apellido);
	}

	@Test
	@DisplayName("Test: Buscar persona por DNI")
	void buscarPorDni() {
		// Given
		String dni = "06";
		when(personaRepository.buscarPorDni(dni)).thenReturn(Optional.of(DatosDummy.alumno02()));

		// When
		Optional<Persona> expected = personaDAO.buscarPorDni(dni);

		// Then
		assertThat(expected.get().getDni()).isEqualTo(dni);

		verify(personaRepository).buscarPorDni(dni);
	}

	@Test
	@DisplayName("Test: Buscar persona apellido")
	void buscarPersonaPorApellido() {
		// Given
		String apellido = "AApellido 03";
		when((List<Persona>)personaRepository.buscarPersonaPorApellido(apellido))
		.thenReturn(Arrays.asList(DatosDummy.alumno03()));

		// When
		List<Persona> expected = (List<Persona>)personaDAO.buscarPersonaPorApellido(apellido);

		// Then
		assertThat(expected.size()).isEqualTo(1);
		assertThat(expected.get(0).getApellido()).isEqualTo(apellido);

		verify(personaRepository).buscarPersonaPorApellido(apellido);
	}

}
