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
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.repositories.PabellonRepository;

public class PabellonDAOImplTest {

	PabellonDAO pabellonDAO;
	PabellonRepository pabellonRepository;

	@BeforeEach
	void setUp() {
		pabellonRepository = mock(PabellonRepository.class);
		pabellonDAO = new PabellonDAOImpl(pabellonRepository);
	}

	@Test
	@DisplayName("Test: Busca pabellones por direccion - localidad ")
	void findPabellonesByDireccionLocalidad() {
		// Given
		String localidad = "Loc01";
		when((List<Pabellon>) pabellonRepository.findPabellonesByDireccionLocalidad(localidad))
				.thenReturn(Arrays.asList(DatosDummy.pabellon01()));

		// When
		List<Pabellon> expected = (List<Pabellon>) pabellonDAO.findPabellonesByDireccionLocalidad(localidad);

		// Then
		assertThat(expected.size()).isEqualTo(1);
		assertThat(expected.get(0)).isEqualTo(DatosDummy.pabellon01());

		verify(pabellonRepository).findPabellonesByDireccionLocalidad(localidad);
	}

	@Test
	@DisplayName("Test: Busca pabellones por su nombre")
	void findPabellonesByNombre() {
		// Given
		String nombre = "Pabellon_02";
		when((List<Pabellon>) pabellonRepository.findPabellonesByNombre(nombre))
				.thenReturn(Arrays.asList(DatosDummy.pabellon02()));

		// When
		List<Pabellon> expected = (List<Pabellon>) pabellonDAO.findPabellonesByNombre(nombre);

		// Then
		assertThat(expected.size()).isEqualTo(1);
		assertThat(expected.get(0)).isEqualTo(DatosDummy.pabellon02());

		verify(pabellonRepository).findPabellonesByNombre(nombre);
	}
}
