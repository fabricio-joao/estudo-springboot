package com.estudo.springBoot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.springBoot.entidades.Produto;

public interface ProdutoRepositorios extends JpaRepository<Produto, Long>{

}
