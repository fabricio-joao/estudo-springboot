package com.estudo.springBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.springBoot.entidades.Categorias;
import com.estudo.springBoot.entidades.Pedido;
import com.estudo.springBoot.entidades.PedidoItens;
import com.estudo.springBoot.entidades.Produtos;
import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.enuns.PedidoStatus;
import com.estudo.springBoot.repositorios.CategoriasRepositorios;
import com.estudo.springBoot.repositorios.PedidoItensRepositorios;
import com.estudo.springBoot.repositorios.PedidoRepositorios;
import com.estudo.springBoot.repositorios.ProdutosRepositorios;
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
	
	@Autowired
	private ProdutosRepositorios prs;
	
	@Autowired
	private PedidoItensRepositorios pir;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Silva", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Luiz", "alex@gmail.com", "977777777", "123456");
		
		ur.saveAll(Arrays.asList(u1, u2));
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PedidoStatus.AGUARDANDO_PAGAMENTO);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, PedidoStatus.PAGO);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, PedidoStatus.AGUARDANDO_PAGAMENTO);
		
		pr.saveAll(Arrays.asList(pedido1, pedido2,pedido3));
		
		Categorias cat1 = new Categorias(null, "Eletronicos");
		Categorias cat2 = new Categorias(null, "Livros");
		Categorias cat3 = new Categorias(null, "Computadores");
		
		cr.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
		Produtos produtos1 = new Produtos(null, "Summa Theologica", "Tratado sobre Teologia", 90.5, "");
		Produtos produtos2 = new Produtos(null, "Smart Tv", "Televisão 40 polegadas", 2190.0, "");
		Produtos produtos3 = new Produtos(null, "Macbook Pro", "Computador", 1250.0, "");
		Produtos produtos4 = new Produtos(null, "Conjunto de Mesa Game", "Mesa com duas cadeiras", 100.99, "");
		Produtos produtos5 = new Produtos(null, "Etica a Nicomaco", "Livro sobre ética", 100.99, "");
		
		produtos1.getCategorias().add(cat2);
		produtos2.getCategorias().add(cat1);
		produtos3.getCategorias().add(cat3);
		produtos4.getCategorias().add(cat3);
		produtos5.getCategorias().add(cat2);
		
	    prs.saveAll(Arrays.asList(produtos1, produtos2, produtos3, produtos4, produtos5));
	    
	    PedidoItens pi1 = new PedidoItens(pedido1, produtos1, 2, produtos1.getPreco());
	    PedidoItens pi2 = new PedidoItens(pedido1, produtos3, 1, produtos1.getPreco());
	    PedidoItens pi3 = new PedidoItens(pedido2, produtos3, 2, produtos3.getPreco());
	    PedidoItens pi4 = new PedidoItens(pedido3, produtos5, 2, produtos5.getPreco());
		
	    pir.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));
	}
}
