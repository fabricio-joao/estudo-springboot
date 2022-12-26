package com.estudo.springBoot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.estudo.springBoot.entidades.Produto;
import com.estudo.springBoot.repositorios.ProdutoRepositorios;

@Service
public class ProdutoServicos {

	@Autowired
	private ProdutoRepositorios pr;
	
	public List<Produto> buscarPorProdutos(){
		return pr.findAll();
	}
	
	public Produto buscarProdutosPorId(@PathVariable Long id) {
		Optional<Produto> obj = pr.findById(id);
		return obj.get();
	}
}
