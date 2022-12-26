package com.estudo.springBoot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.springBoot.entidades.Produto;
import com.estudo.springBoot.servicos.ProdutoServicos;

@RestController 
@RequestMapping(value = "/produtos")
public class ProdutoRecursos {
	
	@Autowired
	private ProdutoServicos ps;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarProdutos(){
		List<Produto> lista = ps.buscarPorProdutos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarProdutosPorId(@PathVariable Long id){
		Produto obj = ps.buscarProdutosPorId(id);
		return ResponseEntity.ok().body(obj);
	}

}
