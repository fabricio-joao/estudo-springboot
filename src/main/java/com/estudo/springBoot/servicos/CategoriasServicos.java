package com.estudo.springBoot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.springBoot.entidades.Categorias;
import com.estudo.springBoot.repositorios.CategoriasRepositorios;

@Service
public class CategoriasServicos {

	@Autowired
	private CategoriasRepositorios cr;
	
	public List<Categorias> buscarPorCategoria(){
		return cr.findAll();
	}
	
	public Categorias buscarCategoriasPorId(Long id) {
		Optional<Categorias> obj = cr.findById(id);
		return obj.get();
	}
}
