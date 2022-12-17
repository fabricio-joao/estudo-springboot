package com.estudo.springBoot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.springBoot.entidades.Categorias;
import com.estudo.springBoot.servicos.CategoriasServicos;

@RestController 
@RequestMapping(value = "/categorias")
public class CategoriasRecursos {

	@Autowired
	private CategoriasServicos cs;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> buscarCategorias(){
		List<Categorias> categorias = cs.buscarPorCategoria();
		return ResponseEntity.ok().body(categorias);
	}
	
	public ResponseEntity<Categorias> buscarPorId(@PathVariable Long id){
		Categorias obj = cs.buscarCategoriasPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
