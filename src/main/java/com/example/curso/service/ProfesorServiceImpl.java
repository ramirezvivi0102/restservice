package com.example.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.dao.IProfesorDao;
import com.example.curso.entity.Profesor;

/**
 *implementacion del servicio profesor con las operaciones del crud 
 */

@Service
public class ProfesorServiceImpl implements IProfesorService{
	
	@Autowired
	private IProfesorDao profesorDao;

	@Override
	@Transactional(readOnly = true) //We indicate that it is for reading only
	public List<Profesor> findAll() {
		// returns list with all teachers
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true) //We indicate that it is for reading only
	public Profesor findProfesor(Profesor profesor) {
		// It returns us the email of the teacher table
		return (Profesor) profesorDao.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional(readOnly = true) //We indicate that it is for reading only
	public Profesor checkProfesorLogin(Profesor profesor) {
		// We send you the email and password to verify that it is correct
		return (Profesor) profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional
	public void deleteProfesor(Profesor profesor) {
		// removes the entity from the record
		profesorDao.deleteById(profesor.getId());
		
	}

	
	@Override
	@Transactional
	public Profesor updateProfesor(Profesor profesor) {
		// update the registry
		return (Profesor)profesorDao.save(profesor);
	}

	@Override
	@Transactional(readOnly = true) //We indicate that it is for reading only
	public Optional<Profesor> findProfesorById(Long profesor_id) {
		// wraps the teacher type object
		return (Optional<Profesor>)profesorDao.findById(profesor_id);
	}

	@Override
	@Transactional
	public void deleteProfesor(Long id) {
		//removes the entity from the record
		profesorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true) //We indicate that it is for reading only
	public Profesor findById(Long id) {
		// It returns an Id or else a null
		return profesorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findByIdSQL(Long id) {
		// method when we make a query
		return profesorDao.findByIdSQL(id);
	}

	@Override
	@Transactional
	public void save(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorDao.save(profesor);
	}
	
	@Override
	@Transactional
	public void deleteAllProfesor() {
		profesorDao.deleteAll();
	}

}
