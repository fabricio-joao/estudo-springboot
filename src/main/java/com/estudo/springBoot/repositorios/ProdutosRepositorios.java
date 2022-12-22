package com.estudo.springBoot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.springBoot.entidades.Produtos;

public interface ProdutosRepositorios extends JpaRepository<Produtos, Long>{

}
