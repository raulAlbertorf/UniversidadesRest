package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;

@Service
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDAO {

	@Autowired
	public CarreraDAOImpl(CarreraRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
		// TODO Auto-generated method stub
		return repository.findCarrerasByNombreContains(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
		// TODO Auto-generated method stub
		return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
		// TODO Auto-generated method stub
		return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return repository.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
	}

	@Override
	@Transactional
	public Carrera actualizar(Carrera carreraEncontrada, Carrera carrera) {
		Carrera carreraActualizada = null;
		carreraEncontrada.setCantidadAnios(carrera.getCantidadAnios());
		carreraEncontrada.setCantidadMaterias(carrera.getCantidadMaterias());
		carreraActualizada = repository.save(carreraEncontrada);
		return carreraActualizada;
	}

}
