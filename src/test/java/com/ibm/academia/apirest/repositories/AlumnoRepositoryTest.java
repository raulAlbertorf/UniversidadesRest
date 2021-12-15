package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;

@DataJpaTest
public class AlumnoRepositoryTest {

	@Autowired
	@Qualifier("repositorioAlumnos")
	private PersonaRepository alumnoRepository;
	
	@Autowired
	private CarreraRepository carreraRrepository;
	
	@Test
	@DisplayName("Test: Bucar alumno por nombre de carrera")
	void buscarAlumnoPorNombreCarrera() {
		//Given
		Iterable<Persona> alumnos = alumnoRepository.saveAll(
				Arrays.asList(
						DatosDummy.alumno01(),
						DatosDummy.alumno02(),
						DatosDummy.alumno03()
				));
		Carrera carrera = carreraRrepository.save(DatosDummy.carrera02());
		alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
		alumnoRepository.saveAll(alumnos);
		
		//when
		Iterable<Persona> expected = ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(carrera.getNombre());
		
		//then
		assertThat(((List<Persona>)expected).size()).isEqualTo(3);
		
	}
	
	@Test
	@DisplayName("Test: Bucar alumno por nombre de carrera sin alumnos")
	void buscarAlumnoPorNombreCarreraSinValores() {
		//Given
		Iterable<Persona> alumnos = alumnoRepository.saveAll(
				Arrays.asList(
						DatosDummy.alumno01(),
						DatosDummy.alumno02(),
						DatosDummy.alumno03()
				));
		Carrera carrera = carreraRrepository.save(DatosDummy.carrera02());
		alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
		alumnoRepository.saveAll(alumnos);
		
		//when
		String nombreCarrea = "Ingenieria Industria";
		Iterable<Persona> expected = ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(nombreCarrea);
		
		//then
		assertThat(((List<Persona>)expected)).isEmpty();
		
	}
}
