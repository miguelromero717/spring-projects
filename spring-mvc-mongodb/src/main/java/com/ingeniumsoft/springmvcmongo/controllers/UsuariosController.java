/**
 * com.ingeniumsoft.springmvcmongo.controllers
 */
package com.ingeniumsoft.springmvcmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ingeniumsoft.springmvcmongo.model.Usuario;
import com.ingeniumsoft.springmvcmongo.services.UsuariosService;

/**
 * @author miguelromero717
 * 12/03/2016
 */
@Controller
public class UsuariosController {
	
	@Autowired
	UsuariosService usuariosService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("usuarios", usuariosService.findAllUsuarios());
		return mv;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView usuarios() {
		ModelAndView mv = new ModelAndView("usuarios/usuarios");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@RequestMapping(value = "/usuarios/save", method = RequestMethod.POST)
	public String saveUsuario(@ModelAttribute Usuario usuario, Model model) {
		
		if(usuario.getId() == null || usuario.getId().equals("")){
			usuariosService.saveUsuario(usuario);
		}else{
			usuariosService.updateUsuario(usuario);
		}
		
		model.addAttribute("usuarios", usuariosService.findAllUsuarios());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/usuarios/edit/{usuarioId}", method = RequestMethod.GET)
	public ModelAndView editUsuario(@PathVariable("usuarioId") String usuarioId){
		ModelAndView mv = new ModelAndView("usuarios/usuarios");
		Usuario user = usuariosService.findUsuarioById(usuarioId);		
		mv.addObject("usuario", user);
		return mv;
	}
	
	@RequestMapping(value = "/usuarios/delete/{usuarioId}", method = RequestMethod.GET)
	public ModelAndView deleteUsuario(@PathVariable("usuarioId") String usuarioId){
		
		ModelAndView mv = new ModelAndView("redirect:/");
		
		usuariosService.deleteUsuario(usuariosService.findUsuarioById(usuarioId));
		
		mv.addObject("usuario", usuariosService.findAllUsuarios());
		
		return mv;
	}
	
}