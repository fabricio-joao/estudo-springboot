package com.estudo.springBoot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.springBoot.entidades.Pedido;
import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.repositorios.PedidoRepositorios;
import com.estudo.springBoot.repositorios.UsuarioRepositorios;

@Service
public class PedidoServicos {
 
	@Autowired
	private PedidoRepositorios pr;
	
	public List<Pedido> buscarPorUsuarios(){
		return pr.findAll();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido> obj = pr.findById(id);
		return obj.get();
	}
}
