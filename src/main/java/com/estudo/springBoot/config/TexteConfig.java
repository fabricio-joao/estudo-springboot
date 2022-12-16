package com.estudo.springBoot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.repositorios.UsuarioRepositorios;

@Configuration 
@Profile("test")
public class TexteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorios ur;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		
		ur.saveAll(Arrays.asList(u1, u2));
	}
}
