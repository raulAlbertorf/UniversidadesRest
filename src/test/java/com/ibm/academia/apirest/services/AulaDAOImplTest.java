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
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.repositories.AulaRepository;

public class AulaDAOImplTest {

	AulaDAO aulaDAO;
	AulaRepository aulaRepository;

	@BeforeEach
	void setUp() {
		aulaRepository = mock(AulaRepository.class);
		aulaDAO = new AulaDAOImpl(aulaRepository);
	}

	@Test
	@DisplayName("Test: Busca aulas por tipo de pizarra")
	void findAulasByPizarron() {
		// Given
		Pizarron pizarra = Pizarron.PIZARRA_BLANCA;
		when((List<Aula>) aulaRepository.findAulasByPizarron(pizarra))
				.thenReturn(Arrays.asList(DatosDummy.aula01(), DatosDummy.aula02(),DatosDummy.aula06()));

		// When
		List<Aula> expected = (List<Aula>) aulaDAO.findAulasByPizarron(pizarra);

		// Then
		assertThat(expected.size()).isEqualTo(3);
		assertThat(expected.get(0)).isEqualTo(DatosDummy.aula01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.aula02());
		assertThat(expected.get(2)).isEqualTo(DatosDummy.aula06());

		verify(aulaRepository).findAulasByPizarron(pizarra);
	}

	@Test
	@DisplayName("Test: Busca aulas por nombre de pabellon")
	void findAulasByPabellonNombre() {
		// Given
		String pabellonNombre = "Pabellon_02";
		when((List<Aula>) aulaRepository.findAulasByPabellonNombre(pabellonNombre))
				.thenReturn(Arrays.asList(DatosDummy.aula05(),DatosDummy.aula06()));

		// When
		List<Aula> expected = (List<Aula>) aulaDAO.findAulasByPabellonNombre(pabellonNombre);

		// Then
		assertThat(expected.size()).isEqualTo(2);
		assertThat(expected.get(0)).isEqualTo(DatosDummy.aula05());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.aula06());

		verify(aulaRepository).findAulasByPabellonNombre(pabellonNombre);
	}

	@Test
	@DisplayName("Test: Busca aula por numero de aula")
	void findAulaByNumeroAula() {
		// Given
		Integer numAula = 1;
		when(aulaRepository.findAulaByNumeroAula(numAula))
				.thenReturn(DatosDummy.aula01());

		// When
		Aula expected = aulaDAO.findAulaByNumeroAula(numAula);

		// Then
		assertThat(expected).isInstanceOf(Aula.class);
		assertThat(expected).isEqualTo(DatosDummy.aula01());


		verify(aulaRepository).findAulaByNumeroAula(numAula);
	}

}
