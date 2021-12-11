package com.ibm.academia.apirest.datos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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
import com.ibm.academia.apirest.repositories.AulaRepository;

public class DatosDummy {
	public static Carrera carrera01() {
		return new Carrera(null, "Ingenieria en Sistemas", 50, 5);
	}
	
	public static Carrera carrera02() {
		return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
	}

	public static Carrera carrera03() {
		return new Carrera(null, "Ingenieria Industria", 60, 5);
	}
	public static Persona empleado01() {
		return new Empleado(null, "ENombre 01", "EApellido 01", "01", new Direccion(), new BigDecimal(10000), TipoEmpleado.ADMINISTRATIVO);
	}
	public static Persona empleado02() {
		return new Empleado(null, "ENombre 02", "EApellido 02", "02", new Direccion(), new BigDecimal(20000), TipoEmpleado.MANTENIMIENTO);
	}
	public static Persona empleado03() {
		return new Empleado(null, "ENombre 03", "EApellido 03", "022", new Direccion(), new BigDecimal(22000), TipoEmpleado.MANTENIMIENTO);
	}
	public static Persona profesor01() {
		return new Profesor(null, "PNombre 01", "PApellido 01", "03", new Direccion(), new BigDecimal(15000));
	}
	public static Persona profesor02() {
		return new Profesor(null, "PNombre 02", "PApellido 02", "04", new Direccion(), new BigDecimal(25000));
	}
	public static Persona profesor03() {
		Profesor profesor = new Profesor(null, "PNombre_03", "PNombre_03", "033", new Direccion(), new BigDecimal(16000));
		Set<Carrera> carreras = new HashSet<Carrera>();
		carreras.add(carrera01());
		carreras.add(carrera03());
		profesor.setCarreras(carreras);
		return profesor;
	}
	public static Persona alumno01() {
		return new Alumno(null, "ANombre 01", "AApellido 01", "05", new Direccion());
	}
	public static Persona alumno02() {
		return new Alumno(null, "ANombre 02", "AApellido 02", "06", new Direccion());
	}
	public static Persona alumno03() {
		return new Alumno(null, "ANombre 03", "AApellido 03", "07", new Direccion());
	}
	public static Persona alumno04() {
		Persona alumno = new Alumno(null, "ANombre 04", "AApellido 04", "08", new Direccion());
		((Alumno)alumno).setCarrera(DatosDummy.carrera03());
		return alumno;
	}
	public static Aula aula01() {
		return new Aula(null, 1, "10x5", 45, Pizarron.PIZARRA_BLANCA);
	}
	public static Aula aula02() {
		return new Aula(null, 2, "11x5", 40, Pizarron.PIZARRA_BLANCA);
	}
	public static Aula aula03() {
		return new Aula(null, 3, "12x5", 50, Pizarron.PIZARRA_TIZA);
	}
	public static Aula aula04() {
		return new Aula(null, 4, "13x5", 55, Pizarron.PIZARRA_TIZA);
	}
	public static Aula aula05() {
		Aula aula = new Aula(null, 5, "14x5", 50, Pizarron.PIZARRA_TIZA);
		aula.setPabellon(DatosDummy.pabellon02());
		return aula;
	}
	public static Aula aula06() {
		Aula aula = new Aula(null, 6, "15x5", 53, Pizarron.PIZARRA_BLANCA);
		aula.setPabellon(DatosDummy.pabellon02());
		return aula;
	}
	public static Pabellon pabellon01() {
		return new Pabellon(null, 150.0, "Pabellon_01", new Direccion("Calle01", "Num1", "Cod1", "Dep1", "Piso01","Loc01"));
	}
	public static Pabellon pabellon02() {
		return new Pabellon(null, 170.0, "Pabellon_02", new Direccion("Calle02", "Num2", "Cod2", "Dep2", "Piso02","Loc02"));
	}
	
}
