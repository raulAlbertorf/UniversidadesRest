package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Pabellon;

@DataJpaTest
public class PabellonRepositoryTest {

	@Autowired
	private PabellonRepository pabellonRepository;

	@BeforeEach
	void setUp() {
		pabellonRepository.saveAll(Arrays.asList(DatosDummy.pabellon01(), DatosDummy.pabellon02()));
	}

	@AfterEach
	void tearDown() {
		pabellonRepository.deleteAll();
	}

	@Test
	@DisplayName("Test: Bucar pabellones por direccion - localidad")
	void findPabellonesByDireccionLocalidad() {
		// Given
		// When
		Iterable<Pabellon> expected = pabellonRepository
				.findPabellonesByDireccionLocalidad(DatosDummy.pabellon02().getDireccion().getLocalidad());
		// Then
		assertThat(((List<Pabellon>) expected).size() == 1).isTrue();
	}

	@Test
	@DisplayName("Test: Bucar pabellones por nombre")
	void findPabellonesByNombre() {
		// Given
		// When
		Iterable<Pabellon> expected = pabellonRepository.findPabellonesByNombre(DatosDummy.pabellon01().getNombre());
		// Then
		assertThat(((List<Pabellon>) expected).size() == 1).isTrue();

	}
}
