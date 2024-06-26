package com.example.curso.entity;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to map the entity table profesores 
 */
@Entity
@Table(name="profesores")
public class Profesor implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre") /* database row*/
	private String nombre; /*database column  */
	
	@Column(length = 60, unique = true )
	private String email;
	
	private String password;
	
	@Column(length = 2000 )
	private String foto;
	
	@Column( name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	
	
	
	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getFoto() {
		return foto;
	}






	public void setFoto(String foto) {
		this.foto = foto;
	}






	public Date getCreateAt() {
		return createAt;
	}






	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}






	private static final long serialVersionUID = 1L;
}
