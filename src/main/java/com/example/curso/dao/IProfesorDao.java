package com.example.curso.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.curso.entity.Profesor;

/**
 * interface DaoProfesores using JPA(CrudRepository)
 */
public interface IProfesorDao  extends CrudRepository<Profesor, Long> {

	public Profesor findByEmail(String email);
	public Profesor findByEmailAndPassword(String email, String Password);
	public Optional<Profesor> findById(Long id);
	
	@Query("select p from Profesor p where p.id=?1")
	public Profesor findByIdSQL(long id);
	
}
