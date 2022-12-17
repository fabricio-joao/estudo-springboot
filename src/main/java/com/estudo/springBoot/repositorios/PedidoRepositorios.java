package com.estudo.springBoot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.springBoot.entidades.Pedido;

public interface PedidoRepositorios extends JpaRepository<Pedido, Long>{

}
