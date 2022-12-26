package com.estudo.springBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.springBoot.entidades.Categoria;
import com.estudo.springBoot.entidades.ItemPedido;
import com.estudo.springBoot.entidades.Pagamento;
import com.estudo.springBoot.entidades.Pedido;
import com.estudo.springBoot.entidades.Produto;
import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.enuns.PedidoStatus;
import com.estudo.springBoot.repositorios.CategoriaRepositorios;
import com.estudo.springBoot.repositorios.ItemPedidoRepositorios;
import com.estudo.springBoot.repositorios.PedidoRepositorios;
import com.estudo.springBoot.repositorios.ProdutoRepositorios;
import com.estudo.springBoot.repositorios.UsuarioRepositorios;

@Configuration 
@Profile("test")
public class TexteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorios ur;
	
	@Autowired
	private PedidoRepositorios pr;
	
	@Autowired
	private CategoriaRepositorios cr;
	
	@Autowired
	private ProdutoRepositorios prs;
	
	@Autowired
	private ItemPedidoRepositorios ipr;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Silva", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Luiz", "alex@gmail.com", "977777777", "123456");
		
		ur.saveAll(Arrays.asList(u1, u2));
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PedidoStatus.AGUARDANDO_PAGAMENTO);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, PedidoStatus.PAGO);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, PedidoStatus.AGUARDANDO_PAGAMENTO);
		
		pr.saveAll(Arrays.asList(pedido1, pedido2,pedido3));
		
		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		cr.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
		Produto produtos1 = new Produto(null, "Summa Theologica", "Tratado sobre Teologia - Santo Tomas De Aquino", 90.5, "");
		Produto produtos2 = new Produto(null, "Smart Tv", "Televisão 40 polegadas", 2190.0, "");
		Produto produtos3 = new Produto(null, "Macbook Pro", "Computador", 1250.0, "");
		Produto produtos4 = new Produto(null, "Conjunto de Mesa Game", "Mesa com duas cadeiras", 100.99, "");
		Produto produtos5 = new Produto(null, "Refuntando Livre-Arbitrio", "Jacob Arminus", 100.99, "");
		
		
		produtos1.getCategorias().add(cat2);
		produtos2.getCategorias().add(cat1);
		produtos3.getCategorias().add(cat3);
		produtos4.getCategorias().add(cat3);
		produtos5.getCategorias().add(cat2);
		
	    prs.saveAll(Arrays.asList(produtos1, produtos2, produtos3, produtos4, produtos5));
	    
	    ItemPedido pi1 = new ItemPedido(pedido1, produtos1, 2, produtos1.getPreco());
	    ItemPedido pi2 = new ItemPedido(pedido1, produtos3, 1, produtos3.getPreco());
	    ItemPedido pi3 = new ItemPedido(pedido2, produtos3, 2, produtos3.getPreco());
	    ItemPedido pi4 = new ItemPedido(pedido3, produtos5, 2, produtos5.getPreco());
		
	    ipr.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));
	    
	    Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T19:53:07Z"), pedido1);
	    
	    pedido1.setPagamento(pag1);
	    pr.save(pedido1);
	}
}
