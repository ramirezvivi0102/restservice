package com.example.curso.controller;




import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entity.Profesor;
import com.example.curso.mapper.Mapper;
import com.example.curso.model.MProfesor;
import com.example.curso.service.IProfesorService;




/**
 * Class controller or End point to the Access profesores 
 */
@RestController
@RequestMapping("/api")

public class ProfesorRestController {
	
	
	@Autowired
	private IProfesorService profesorService;
	
	//find all the methods and bring them
	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores(){
		return profesorService.findAll();
		
	}
	
	@PostMapping("/find_profesor")
	public ResponseEntity<?> findProfesor( @RequestBody Profesor profesor){
		Profesor profesorDb = profesorService.findProfesor(profesor);
		if(profesorDb!=null) {
			return new ResponseEntity<>(profesorDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/profesores")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor ){
		if (profesorService.findProfesor(profesor)==null) {
			profesorService.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor ){
		 Profesor profesorDb = profesorService.checkProfesorLogin(profesor);
		if (profesorDb!= null) {
			List<Profesor> profesores = new ArrayList<>();
			profesores.add(profesorDb);
			List<MProfesor> mProfesores = new ArrayList<>();
			mProfesores= Mapper.convertirLista(profesores);
		return new ResponseEntity<>(mProfesores, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);
		}
	}
	
	
}
