package com.estudo.springBoot.entidades;

import java.io.Serializable;
import java.util.Objects;

import com.estudo.springBoot.entidades.pk.PedidosPorItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PedidosItens")
public class PedidoItens implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidosPorItemPK id = new PedidosPorItemPK();
	private Integer quantidade;
	private Double preco;

	public PedidoItens() {
		
	}

	public PedidoItens(Pedido pedido, Produtos produtos, Integer quantidade, Double preco) {
		id.setPedido(pedido);
		id.setProdutos(produtos);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedidos(Pedido pedido) {
		id.setPedido(pedido);
	}

	public Produtos getProdutos() {
		return id.getProdutos();
	}

	public void setProdutos(Produtos produtos) {
		id.setProdutos(produtos);
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItens other = (PedidoItens) obj;
		return Objects.equals(id, other.id);
	}
}
