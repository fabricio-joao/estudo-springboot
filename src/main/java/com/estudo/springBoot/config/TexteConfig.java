package com.estudo.springBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.springBoot.entidades.Categorias;
import com.estudo.springBoot.entidades.Pedido;
import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.enuns.PedidoStatus;
import com.estudo.springBoot.repositorios.CategoriasRepositorios;
import com.estudo.springBoot.repositorios.PedidoRepositorios;
import com.estudo.springBoot.repositorios.UsuarioRepositorios;

@Configuration 
@Profile("test")
public class TexteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorios ur;
	
	@Autowired
	private PedidoRepositorios pr;
	
	@Autowired
	private CategoriasRepositorios cr;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		ur.saveAll(Arrays.asList(u1, u2));
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PedidoStatus.AGUARDANDO_PAGAMENTO);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, PedidoStatus.PAGO);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, PedidoStatus.AGUARDANDO_PAGAMENTO);
		
		pr.saveAll(Arrays.asList(pedido1, pedido2,pedido3));
		
		Categorias cat1 = new Categorias(null, "Electronics");
		Categorias cat2 = new Categorias(null, "Books");
		Categorias cat3 = new Categorias(null, "Computers");
		
		cr.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
}
