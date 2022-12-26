package com.estudo.springBoot.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.servicos.UsuarioServicos;

@RestController 
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {
	
	@Autowired
	private UsuarioServicos us;
	
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
	
	@PostMapping
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario obj){
		 obj = us.inserirUsuario(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
		us.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario obj){
		obj = us.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
