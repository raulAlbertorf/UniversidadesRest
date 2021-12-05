package com.ibm.academia.apirest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Empleado;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.AulaDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.EmpleadoDAO;
import com.ibm.academia.apirest.services.PabellonDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import com.ibm.academia.apirest.services.ProfesorDAO;

@Component
public class Comandos implements CommandLineRunner {


	@Autowired
	private CarreraDAO carreraDAO;
	
	@Autowired
	private AulaDAO aulaDAO;
	
	@Autowired
	private PabellonDAO pabellonDAO;

	@Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO alumnoDAO;

	@Autowired
	@Qualifier("profesorDAOImpl")
	private PersonaDAO profesorDAO;
	
	@Autowired
	@Qualifier("empleadoDAOImpl")
	private PersonaDAO empleadoDAO;

	@Override
	public void run(String... args) throws Exception {
		//CARGA DE BASE DE DATOS
		// 1.- Crear 8 Carreras
		/*Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
		Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
		Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
		Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
		Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
		Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
		Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
		Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

		carreraDAO.guardar(ingSistemas);
		carreraDAO.guardar(ingIndustrial);
		carreraDAO.guardar(ingAlimentos);
		carreraDAO.guardar(ingElectronica);
		carreraDAO.guardar(licSistemas);
		carreraDAO.guardar(licTurismo);
		carreraDAO.guardar(licYoga);
		carreraDAO.guardar(licRecursos);*/

		// 2.- Crear 4 profesores
		/*Direccion direccion1 = new Direccion("Calle 1", "1", "1", "101", "", "Colonia 1");
		Persona profesor1 = new Profesor(null, "Nombre 1", "Apellido 1", "Dni 1", direccion1, new BigDecimal(10000));
		Persona profesorGuardado1 = profesorDAO.guardar(profesor1);
		
		Direccion direccion2 = new Direccion("Calle 2", "2", "2", "102", "", "Colonia 2");
		Persona profesor2 = new Profesor(null, "Nombre 2", "Apellido 2", "Dni 2", direccion2, new BigDecimal(12000));
		Persona profesorGuardado2 = profesorDAO.guardar(profesor2);
		
		Direccion direccion3 = new Direccion("Calle 3", "3", "3", "103", "", "Colonia 3");
		Persona profesor3 = new Profesor(null, "Nombre 3", "Apellido 3", "Dni 3", direccion3, new BigDecimal(13000));
		Persona profesorGuardado3 = profesorDAO.guardar(profesor3);*/
		
		/*Direccion direccion4 = new Direccion("Calle 4", "4", "4", "104", "", "Colonia 4");
		Persona profesor4 = new Profesor(null, "Nombre 4", "Apellido 4", "Dni 4", direccion4, new BigDecimal(14000));
		Persona profesorGuardado4 = profesorDAO.guardar(profesor4);*/
		
		// 3.- Asociar Profesor 1 con carreras 1,2,3
		/*Set<Carrera> carreas1 = new HashSet<>();
		Optional<Carrera> oCarrera1 = carreraDAO.buscarPorId(1);
		Optional<Carrera> oCarrera2 = carreraDAO.buscarPorId(2);
		Optional<Carrera> oCarrera3 = carreraDAO.buscarPorId(3);
		carreas1.add((Carrera) oCarrera1.get());
		carreas1.add((Carrera) oCarrera2.get());
		carreas1.add((Carrera) oCarrera3.get());
		((Profesor)profesorGuardado1).setCarreras(carreas1);
		profesorGuardado1 = profesorDAO.guardar(profesorGuardado1);*/
		
		// 4.- Asociar Profesor 2 con carreras 4,5
		/*Set<Carrera> carreas2 = new HashSet<>();
		Optional<Carrera> oCarrera4 = carreraDAO.buscarPorId(4);
		Optional<Carrera> oCarrera5 = carreraDAO.buscarPorId(5);
		carreas2.add((Carrera) oCarrera4.get());
		carreas2.add((Carrera) oCarrera5.get());
		((Profesor)profesorGuardado2).setCarreras(carreas2);
		profesorGuardado2 = profesorDAO.guardar(profesorGuardado2);*/
		
		// 5.- Asociar Profesor 3 con carreras 6,7,8
		/*Set<Carrera> carreas3 = new HashSet<>();
		Optional<Carrera> oCarrera6 = carreraDAO.buscarPorId(6);
		Optional<Carrera> oCarrera7 = carreraDAO.buscarPorId(7);
		Optional<Carrera> oCarrera8 = carreraDAO.buscarPorId(8);
		carreas3.add((Carrera) oCarrera6.get());
		carreas3.add((Carrera) oCarrera7.get());
		carreas3.add((Carrera) oCarrera8.get());
		((Profesor)profesorGuardado3).setCarreras(carreas3);
		profesorGuardado3 = profesorDAO.guardar(profesorGuardado3);*/
		
		//6.- Asociar Profesor 4 con Carrera 1,5,8
		/*Set<Carrera> carreas4 = new HashSet<>();
		Optional<Carrera> oCarrera1 = carreraDAO.buscarPorId(1);
		Optional<Carrera> oCarrera5 = carreraDAO.buscarPorId(5);
		Optional<Carrera> oCarrera8 = carreraDAO.buscarPorId(8);
		carreas4.add((Carrera) oCarrera1.get());
		carreas4.add((Carrera) oCarrera5.get());
		carreas4.add((Carrera) oCarrera8.get());
		((Profesor)profesorGuardado4).setCarreras(carreas4);
		profesorGuardado4 = profesorDAO.guardar(profesorGuardado4);*/

		//8.- Crear Alumno 1, 2, 3, 4
		/*Direccion direccion5 = new Direccion("Calle 5","5","5","205","","Colonia 5");
		Persona alumno1 = new Alumno(null, "Nombre_Alum 1", "Apellido_Alum 1", "Dni 5", direccion5);
		Persona personaGuardar5 = alumnoDAO.guardar(alumno1);
		
		Direccion direccion6 = new Direccion("Calle 6","6","6","206","","Colonia 6");
		Persona alumno2 = new Alumno(null, "Nombre_Alum 2", "Apellido_Alum 2", "Dni 6", direccion6);
		Persona personaGuardar6 = alumnoDAO.guardar(alumno2);
		
		Direccion direccion7 = new Direccion("Calle 7","7","7","207","","Colonia 7");
		Persona alumno3 = new Alumno(null, "Nombre_Alum 3", "Apellido_Alum 3", "Dni 7", direccion7);
		Persona personaGuardar7 = alumnoDAO.guardar(alumno3);
				
		Direccion direccion8 = new Direccion("Calle 8","8","7","208","","Colonia 8");
		Persona alumno4 = new Alumno(null, "Nombre_Alum 4", "Apellido_Alum 4", "Dni 8", direccion8);
		Persona personaGuardar8 = alumnoDAO.guardar(alumno4);*/
		
		//9.- Asociar Alumnos (1 - 4) a Carrera (8 - 6)
		/*Optional<Carrera> oCarrera8 = carreraDAO.buscarPorId(8);
		Optional<Persona> alumno1 = alumnoDAO.buscarPorId(6);
		((Alumno)alumno1.get()).setCarrera((Carrera)oCarrera8.get());
		Persona alumnoGuardado1 = alumnoDAO.guardar((Alumno)alumno1.get());
		
		Optional<Carrera> oCarrera7 = carreraDAO.buscarPorId(7);
		Optional<Persona> alumno2 = alumnoDAO.buscarPorId(7);
		((Alumno)alumno2.get()).setCarrera((Carrera)oCarrera7.get());
		Persona alumnoGuardado2 = alumnoDAO.guardar((Alumno)alumno2.get());
		
		Optional<Carrera> oCarrera6 = carreraDAO.buscarPorId(6);
		Optional<Persona> alumno3 = alumnoDAO.buscarPorId(8);
		((Alumno)alumno3.get()).setCarrera((Carrera)oCarrera6.get());
		Persona alumnoGuardado3 = alumnoDAO.guardar((Alumno)alumno3.get());
		
		Optional<Carrera> oCarrera5 = carreraDAO.buscarPorId(1);
		Optional<Persona> alumno4 = alumnoDAO.buscarPorId(9);
		((Alumno)alumno4.get()).setCarrera((Carrera)oCarrera5.get());
		Persona alumnoGuardado4 = alumnoDAO.guardar((Alumno)alumno4.get());*/
		
		//Crear Empleados 1 a 4
		/*Direccion direccion9 = new Direccion("Calle 9", "9", "9", "109", "", "Colonia 9");
		Persona empleado1 = new Empleado(null, "Nombre_Emp 1", "Apellido_Emp 1", "Dni 9", direccion9, new BigDecimal(24500),TipoEmpleado.ADMINISTRATIVO);
		Persona empleadoGuardado1 = empleadoDAO.guardar(empleado1);
		
		Direccion direccion10 = new Direccion("Calle 10", "10", "10", "110", "10", "Colonia 10");
		Persona empleado2 = new Empleado(null, "Nombre_Emp 2", "Apellido_Emp 2", "Dni 10", direccion10, new BigDecimal(25500),TipoEmpleado.MANTENIMIENTO);
		Persona empleadoGuardado2 = empleadoDAO.guardar(empleado2);
		
		Direccion direccion11 = new Direccion("Calle 11", "11", "11", "111", "11", "Colonia 11");
		Persona empleado3 = new Empleado(null, "Nombre_Emp 3", "Apellido_Emp 3", "Dni 11", direccion10, new BigDecimal(26500),TipoEmpleado.MANTENIMIENTO);
		Persona empleadoGuardado3 = empleadoDAO.guardar(empleado3);
		
		Direccion direccion12 = new Direccion("Calle 12", "12", "12", "112", "12", "Colonia 12");
		Persona empleado4 = new Empleado(null, "Nombre_Emp 4", "Apellido_Emp 4", "Dni 12", direccion10, new BigDecimal(27500),TipoEmpleado.ADMINISTRATIVO);
		Persona empleadoGuardado4 = empleadoDAO.guardar(empleado4);*/
		
		//Crear Pabellones 2
		/*Direccion direccionPabellon1 = new Direccion("Calle Pabellon 1", "1", "1", "121", "1", "Colonia Pabellon 1");
		Pabellon pabellon1 = new Pabellon(null,1000.0,"Pabellon_01", direccionPabellon1);
		Pabellon pabellonGuardado1 = pabellonDAO.guardar(pabellon1);

		Direccion direccionPabellon2 = new Direccion("Calle Pabellon 2", "2", "2", "122", "2", "Colonia Pabellon 2");
		Pabellon pabellon2 = new Pabellon(null,2000.0,"Pabellon_02", direccionPabellon2);
		Pabellon pabellonGuardado2 = pabellonDAO.guardar(pabellon2);*/
		
		//Crear 7 Aulas
		/*Aula aula1 = new Aula(null, 1, "10x4", 50, Pizarron.PIZARRA_BLANCA);
		Aula aula2 = new Aula(null, 2, "10x3", 40, Pizarron.PIZARRA_TIZA);
		Aula aula3 = new Aula(null, 3, "10x5", 55, Pizarron.PIZARRA_BLANCA);
		Aula aula4 = new Aula(null, 4, "11x3", 55, Pizarron.PIZARRA_TIZA);
		Aula aula5 = new Aula(null, 5, "12x2", 35, Pizarron.PIZARRA_BLANCA);
		Aula aula6 = new Aula(null, 6, "11x5", 55, Pizarron.PIZARRA_TIZA);
		Aula aula7 = new Aula(null, 7, "12x4", 60, Pizarron.PIZARRA_BLANCA);
		
		
		Aula aulaGuardada1 = aulaDAO.guardar(aula1);
		Aula aulaGuardada2 = aulaDAO.guardar(aula2);
		Aula aulaGuardada3 = aulaDAO.guardar(aula3);
		Aula aulaGuardada4 = aulaDAO.guardar(aula4);
		Aula aulaGuardada5 = aulaDAO.guardar(aula5);
		Aula aulaGuardada6 = aulaDAO.guardar(aula6);
		Aula aulaGuardada7 = aulaDAO.guardar(aula7);
		
		//Asignamos Aulas a Pabellones
		aulaGuardada1.setPabellon(pabellonDAO.buscarPorId(1).get());
		aulaGuardada2.setPabellon(pabellonDAO.buscarPorId(2).get());
		aulaGuardada3.setPabellon(pabellonDAO.buscarPorId(1).get());
		aulaGuardada4.setPabellon(pabellonDAO.buscarPorId(2).get());
		aulaGuardada5.setPabellon(pabellonDAO.buscarPorId(1).get());
		aulaGuardada6.setPabellon(pabellonDAO.buscarPorId(2).get());
		aulaGuardada7.setPabellon(pabellonDAO.buscarPorId(1).get());
		
		aulaGuardada1 = aulaDAO.guardar(aulaGuardada1);
		aulaGuardada2 = aulaDAO.guardar(aulaGuardada2);
		aulaGuardada3 = aulaDAO.guardar(aulaGuardada3);
		aulaGuardada4 = aulaDAO.guardar(aulaGuardada4);
		aulaGuardada5 = aulaDAO.guardar(aulaGuardada5);
		aulaGuardada6 = aulaDAO.guardar(aulaGuardada6);
		aulaGuardada7 = aulaDAO.guardar(aulaGuardada7);*/
		
		

		// -- INICIO -- TALLER 3//
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		 * ProfesorRepository: 1. Agregar método
		 * "Iterable<Persona> findProfesoresByCarrera(String carrera)", el cual a través
		 * de anotación @Query se debe de buscar los profesores que se encuentren
		 * asociados a dicha carrera donde el nombre de la misma sea igual al ingresado
		 * en el parámetro del método.
		 * --------------------------------------------------------------------------------
		 */
		
		// 1.- Buscar Profesores asociados a una carrera con nombre M
		/*Iterable<Persona> profesoresCarreraNombre = ((ProfesorDAO) profesorDAO).findProfesoresByCarrera("Ingenieria en Sistemas");
		 profesoresCarreraNombre.forEach(System.out::println);
		 
		 Set<Persona> profesores1 = new HashSet<>();
		 ((ProfesorDAO) profesorDAO).findProfesoresByCarreraContains("Licenciatura").forEach(profesores1::add);
		 profesores1.forEach(System.out::println);
		 
		 Set<Persona> profesores2 = new HashSet<>();
		 ((ProfesorDAO) profesorDAO).findProfesoresByCarreraContains("Ingenieria").forEach(profesores2::add);
		 profesores2.forEach(System.out::println);*/
		 
		 /*
		  * EmpleadoRepository: 2.	Agregar método 
		  * "Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);", 
		  * el cual a través de anotación @Query se debe de buscar los empleados que se 
		  * encuentren asociados a dicho tipo de empleado el cual será ingresado por parámetro
		  * del método.
		  * 
		  */
			/*Iterable<Persona> empleadosAdministrativos = ((EmpleadoDAO) empleadoDAO).findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO); 
			empleadosAdministrativos.forEach(System.out::println);
			
			Iterable<Persona> empleadosMantenimiento = ((EmpleadoDAO) empleadoDAO).findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO); 
			empleadosMantenimiento.forEach(System.out::println);*/
		
		
			/*
			 * CarreraRepository: 3.	Agregar método
			 * "Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);", 
			 * el cual a través de anotación @Query se debe de buscar las carreras que se encuentren asociados a 
			 * dicho profesor, buscando al mismo por nombre y apellido, los cuales serán ingresados por parámetros del método.
			 */
			/*Iterable<Carrera> carreras = carreraDAO.buscarCarrerasPorProfesorNombreYApellido("Nombre 1", "Apellido 1");
			carreras.forEach(System.out::println);
			
			Iterable<Carrera> carreras2 = carreraDAO.buscarCarrerasPorProfesorNombreYApellido("Nombre 2", "Apellido 2");
			carreras2.forEach(System.out::println);*/
		
			/*
			 * AulaRepository:
			 * 1.	Agregar método para buscar las aulas que correspondan al tipo de pizarrón ingresado por parámetro, 
			 * el cual debe de realizarse a través de Query Method.
			 * 2.	Agregar método para buscar las aulas que correspondan al nombre de cierto pabellón ingresado por parámetro, 
			 * el cual debe de realizarse a través de Query Method.
			 * 3.	Agregar método para buscar el aula que corresponda al numero de aula ingresado por parámetro, 
			 * el cual debe de realizarse a través de Query Method.
			 */
		
			/*Iterable<Aula> aulasPizarraBlanca = aulaDAO.findAulasByPizarron(Pizarron.PIZARRA_BLANCA);
			aulasPizarraBlanca.forEach(System.out::println);
			
			Iterable<Aula> aulasPabellonNombre = aulaDAO.findAulasByPabellonNombre("Pabellon_0");
			aulasPabellonNombre.forEach(System.out::println);
			
			Aula aulaNum1 = aulaDAO.findAulaByNumeroAula(1);
			System.out.println(aulaNum1.toString());*/

			/*
			 * PabellonRepository:
			 * 1.	Agregar método para buscar el/los pabellón/es que se encuentran en una localidad en particular 
			 * la cual será ingresada por parámetro, el cual debe de realizarse a través de Query Method.
			 * 2.	Agregar método para buscar el/los pabellón/es por un nombre de pabellón en particular 
			 * la cual será ingresada por parámetro, el cual debe de realizarse a través de Query Method.
			 */
			
			/*Iterable<Pabellon> pabellonesLocalidad = pabellonDAO.findPabellonesByDireccionLocalidad("Colonia Pabellon 1");
			pabellonesLocalidad.forEach(System.out::println);
			
			Iterable<Pabellon> pabellonesNombre = pabellonDAO.findPabellonesByNombre("Pabellon_02");
			pabellonesNombre.forEach(System.out::println);*/
			
			

		 	
			 

		 
	}

}
