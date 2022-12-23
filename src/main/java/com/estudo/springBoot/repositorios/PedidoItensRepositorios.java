package com.estudo.springBoot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.springBoot.entidades.PedidoItens;

public interface PedidoItensRepositorios extends JpaRepository<PedidoItens, Long>{

}
