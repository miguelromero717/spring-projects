/**
 * com.ingeniumsoft.springmvcmongo.repositories
 */
package com.ingeniumsoft.springmvcmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ingeniumsoft.springmvcmongo.model.Usuario;

/**
 * @author miguelromero717
 * 13/03/2016
 */
public interface UsuariosRepository extends MongoRepository<Usuario, String> {

}