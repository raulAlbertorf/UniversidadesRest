package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Empleado;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.models.entities.Profesor;

@DataJpaTest
public class PersonaRepositoryTest {

	@Autowired
	@Qualifier("repositorioAlumnos")
	private PersonaRepository alumnoRepository;
	
	@Autowired
	@Qualifier("repositorioEmpleado")
	private PersonaRepository empleadoRepository;
	
	@Autowired
	@Qualifier("repositorioProfesor")
	private PersonaRepository profesorRepository;
	
	
	@Test
	@DisplayName("Tets: Buscar por nombre y apellido")
	void buscarPorNombreApellido() {
	
		Persona empleadoGuardado = empleadoRepository.save(DatosDummy.empleado01());
		
		Optional<Persona> oEmpleado = empleadoRepository.buscarPorNombreApellido(DatosDummy.empleado01().getNombre(), DatosDummy.empleado01().getApellido());
		
		assertThat(oEmpleado.get()).isInstanceOf(Empleado.class);
		assertThat(oEmpleado.get()).isEqualTo(empleadoGuardado);
		
	}
	
	@Test
	@DisplayName("Tets: Buscar por DNI")
	void buscarPorDni() {
		//Given 
		Persona profesorGuardado = profesorRepository.save(DatosDummy.profesor01());
		
		//when
		Optional<Persona> expected = profesorRepository.buscarPorDni(DatosDummy.profesor01().getDni());
		
		//then
		assertThat(expected.get()).isInstanceOf(Profesor.class);
		assertThat(expected.get()).isEqualTo(profesorGuardado);
		assertThat(expected.get().getDni()).isEqualTo(profesorGuardado.getDni());
		
	}
	
	@Test
	@DisplayName("Tets: Buscar persona por Apellido")
	void buscarPersonaPorApellido() {
		//Given
		Iterable<Persona> personas = alumnoRepository.saveAll(
					Arrays.asList(
							DatosDummy.alumno01(),
							DatosDummy.alumno02(),
							DatosDummy.alumno03()
					));
		//When
		String apellido = "AApellido";
		Iterable<Persona> expected = alumnoRepository.buscarPersonaPorApellido(apellido);
		
		//That
		assertThat(((List<Persona>)expected).size()).isEqualTo(3);
	}

}
