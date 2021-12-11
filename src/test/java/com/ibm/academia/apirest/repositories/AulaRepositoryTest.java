package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.Pizarron;

@DataJpaTest
public class AulaRepositoryTest {

	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired
	private PabellonRepository pabellonRepository;

	@BeforeEach
	void setUp() {
		aulaRepository.saveAll(
				Arrays.asList(
						DatosDummy.aula01(), 
						DatosDummy.aula02(), 
						DatosDummy.aula03(), 
						DatosDummy.aula04()		
		));
	}
	
	@AfterEach
	void tearDown() {
		aulaRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Bucar aulas por tipo de pizarra")
	void findAulasByPizarron() {
		// Given

		// When
		Iterable<Aula> expected = aulaRepository.findAulasByPizarron(Pizarron.PIZARRA_BLANCA);
				
		// Then
		assertThat(((List<Aula>)expected).size()).isEqualTo(2);
	}

	@Test
	@DisplayName("Test: Bucar aulas por tipo de pizarra")
	void findAulasByPabellonNombre() {
		
		Pabellon pabellon = pabellonRepository.save(DatosDummy.pabellon01());
		//Given		
		Iterable<Aula> aulas = aulaRepository.findAll();
		aulas.forEach(aula -> aula.setPabellon(pabellon));
		aulaRepository.saveAll(aulas);
		
		//When
		String nombrePabellon = "Pabellon_01";
		Iterable<Aula> expected = aulaRepository.findAulasByPabellonNombre(nombrePabellon);
		
		//Then
		assertThat(((List<Aula>)expected).size()).isEqualTo(4);
	}

	@Test
	@DisplayName("Test: Bucar aula por numero de aula")
	void findAulaByNumeroAula() {
		//Given
		
		//When
		Aula expected = aulaRepository.findAulaByNumeroAula(DatosDummy.aula02().getNumeroAula());
		
		//Then
		assertThat(expected).isInstanceOf(Aula.class);
		assertThat(expected.getNumeroAula()).isEqualTo(2);
	}
}
