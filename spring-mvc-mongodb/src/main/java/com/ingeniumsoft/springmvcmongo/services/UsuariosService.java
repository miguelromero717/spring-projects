/**
 * com.ingeniumsoft.springmvcmongo.services
 */
package com.ingeniumsoft.springmvcmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.ingeniumsoft.springmvcmongo.model.Usuario;
import com.ingeniumsoft.springmvcmongo.repositories.UsuariosRepository;

/**
 * @author miguelromero717
 * 13/03/2016
 */
@Service
public class UsuariosService {
	
	@Autowired
	UsuariosRepository usuarioRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Usuario> findAllUsuarios(){
		return usuarioRepository.findAll();
		//return mongoTemplate.findAll(Usuario.class);
	}
	
	public void saveUsuario(Usuario usuario){
		//mongoTemplate.insert(usuario);
		usuarioRepository.insert(usuario);
	}
	
	public void updateUsuario(Usuario usuario){
		//mongoTemplate.save(usuario);
		usuarioRepository.save(usuario);
	}
	
	public void deleteUsuario(Usuario usuario){
		//mongoTemplate.remove(usuario);
		usuarioRepository.delete(usuario);
	}
	
	public Usuario findUsuarioById(String id){
		return usuarioRepository.findOne(id);
	}
}