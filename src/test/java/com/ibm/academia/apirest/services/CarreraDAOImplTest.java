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
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;

public class CarreraDAOImplTest {

	CarreraDAO carreraDAO;
	CarreraRepository carreraRepository;

	@BeforeEach
	void setUp() {
		carreraRepository = mock(CarreraRepository.class);
		carreraDAO = new CarreraDAOImpl(carreraRepository);
	}

	@Test
	@DisplayName("Test: Busca carreras por nombre contenido")
	void findCarrerasByNombreContains() {
		// Given
		String nombre = "Ingenieria";
		when(carreraRepository.findCarrerasByNombreContains(nombre))
				.thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

		// When
		List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

		// Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

		verify(carreraRepository).findCarrerasByNombreContains(nombre);
	}

	@Test
	@DisplayName("Test: Busca carreras por nombre contenido ignorar case-sensitive")
	void findCarrerasByNombreContainsIgnoreCase() {
		// Given
		String nombre = "ingenieria";
		when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
				.thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

		// When
		List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

		// Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

		verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
	}

	@Test
	@DisplayName("Test: Busca carreras por cantidad de años mayor")
	void findCarrerasByCantidadAniosAfter() {
		// Given
		Integer anios= 4;
		when(carreraRepository.findCarrerasByCantidadAniosAfter(anios))
				.thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera02(), DatosDummy.carrera03()));

		// When
		List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(anios);

		// Then
		assertThat(expected.size()).isEqualTo(3);
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera02());
		assertThat(expected.get(2)).isEqualTo(DatosDummy.carrera03());

		verify(carreraRepository).findCarrerasByCantidadAniosAfter(anios);
	}

	@Test
	@DisplayName("Test: Buscar todas las carreras por nombre y apellido del profesor")
	void buscarCarrerasPorProfesorNombreYApellido() {
		String nombre = "PNombre_03";
		String apellido = "PNombre_03";
		when(carreraRepository.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido))
				.thenReturn(Arrays.asList(DatosDummy.carrera01(),DatosDummy.carrera02()));

		// When
		List<Carrera> expected = (List<Carrera>) carreraDAO.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);

		// Then
		assertThat(expected.size()).isEqualTo(2);
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera02());

		verify(carreraRepository).buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
	}

}
