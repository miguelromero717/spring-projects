/**
 * com.ingeniumsoft.springmvcmongo.model
 */
package com.ingeniumsoft.springmvcmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author miguelromero717
 * 13/03/2016
 */
@Document
public class Usuario {
	
	@Id
	private String id;
	
	private String nombres;
	private String apellidos;
	private Integer edad;
	
	public Usuario(){}
	
	/**
	 * @param id
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 */
	@PersistenceConstructor
	public Usuario(String nombres, String apellidos, Integer edad) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	
	

}
