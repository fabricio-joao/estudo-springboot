package com.estudo.springBoot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.springBoot.entidades.Usuario;

public interface UsuarioRepositorios extends JpaRepository<Usuario, Long>{

}
