package com.estudo.springBoot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.springBoot.UsuarioServicos;
import com.estudo.springBoot.entidades.Usuario;

@RestController 
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {
	
	@Autowired
	UsuarioServicos us;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarUsuarios(){
	List<Usuario> lista = us.buscarPorUsuarios();
	 return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
		Usuario obj = us.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
