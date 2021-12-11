package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;

@DataJpaTest
public class CarreraRepositoryTest {
	
	@Autowired
	private CarreraRepository repository;
	
	@BeforeEach
	void setUp() {
		repository.save(DatosDummy.carrera01());
		repository.save(DatosDummy.carrera02());
		repository.save(DatosDummy.carrera03());	
	}
	
	@AfterEach
	void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	void findCarrerasByCantidadAnios() {
		//Given
		
		//when
		Iterable<Carrera> expected =  repository.findCarrerasByCantidadAnios(5);
		
		//then
		assertThat(((List<Carrera>)expected).size()==2).isTrue();
		
		
	}

	@Test
	@DisplayName("Test: Buscar carreras por nombre")
	void findCarrerasByNombreContains() {
		//Given
		
		//when
		Iterable<Carrera> expected =  repository.findCarrerasByNombreContains("Sistemas");
		
		//then
		assertThat(((List<Carrera>)expected).size()==2).isTrue();
	}

	@Test
	@DisplayName("Test: Buscar por nombre no-case-sensitive")
	void findCarrerasByNombreContainsIgnoreCase() {

		//Given
//				repository.save(DatosDummy.carrera01());
//				repository.save(DatosDummy.carrera02());
//				repository.save(DatosDummy.carrera03());
				
				//when
				Iterable<Carrera> expected =  repository.findCarrerasByNombreContainsIgnoreCase("sistemas");
				
				//then
				assertThat(((List<Carrera>)expected).size()==2).isTrue();
	}

	@Test
	void findCarrerasByCantidadAniosAfter() {
		//Given
//		repository.save(DatosDummy.carrera01());
//		repository.save(DatosDummy.carrera02());
//		repository.save(DatosDummy.carrera03());
		
		//when
		Iterable<Carrera> expected =  repository.findCarrerasByCantidadAniosAfter(4);
		
		//then
		assertThat(((List<Carrera>)expected).size()==2).isTrue();
	}

	@Test
	@Disabled
	void buscarCarrerasPorProfesorNombreYApellido() {
		
	}
}
