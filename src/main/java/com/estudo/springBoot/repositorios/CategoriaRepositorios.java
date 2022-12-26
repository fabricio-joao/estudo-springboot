package com.estudo.springBoot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.springBoot.entidades.Categoria;

public interface CategoriaRepositorios extends JpaRepository<Categoria, Long>{

}
