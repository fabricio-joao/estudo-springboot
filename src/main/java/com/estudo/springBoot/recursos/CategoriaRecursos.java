package com.estudo.springBoot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.springBoot.entidades.Categoria;
import com.estudo.springBoot.servicos.CategoriaServicos;

@RestController 
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {

	@Autowired
	private CategoriaServicos cs;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarPorCategorias(){
		List<Categoria> lista = cs.buscarPorCategorias();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> burcarCategoriasPorId(@PathVariable Long id){
		Categoria obj = cs.buscarCategoriasPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
