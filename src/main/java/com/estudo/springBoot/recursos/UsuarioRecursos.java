package com.estudo.springBoot.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.springBoot.entidades.Usuario;

@RestController 
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {
	
	@GetMapping
	public ResponseEntity<Usuario> buscarUsuarios(){
	 Usuario usuario = new Usuario(1L, "Jose Agostinho", "jose@gmail.com", "319943510231", "99pi7");
	 return ResponseEntity.ok().body(usuario);
	}
}
