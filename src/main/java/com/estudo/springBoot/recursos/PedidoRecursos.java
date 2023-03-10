package com.estudo.springBoot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.estudo.springBoot.entidades.Pedido;
import com.estudo.springBoot.servicos.PedidoServicos;

@RestController 
@RequestMapping(value = "/pedidos")
public class PedidoRecursos {

	@Autowired
	private PedidoServicos ps;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarPorPedidos(){
		List<Pedido> lista = ps.buscarPorUsuarios();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido>buscarPedidosPorId(@PathVariable Long id){
		Pedido obj = ps.buscarPorId(id);
		return ResponseEntity.ok().body(obj); 
	}
}
