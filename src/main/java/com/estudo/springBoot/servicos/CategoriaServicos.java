package com.estudo.springBoot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.springBoot.entidades.Categoria;
import com.estudo.springBoot.repositorios.CategoriaRepositorios;
import com.estudo.springBoot.repositorios.PedidoRepositorios;

@Service
public class CategoriaServicos {
	
	@Autowired
	private CategoriaRepositorios cr;
	
	public List<Categoria> buscarPorCategorias(){
		return cr.findAll();
	}
	
	public Categoria buscarCategoriasPorId(Long id) {
		Optional<Categoria> obj = cr.findById(id);
		return obj.get();
	}

}
