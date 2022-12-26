package com.estudo.springBoot.entidades;

import java.io.Serializable;
import java.util.Objects;

import com.estudo.springBoot.entidades.pk.PedidoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Itens_Pedidos")
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();
	
	private Integer quantidade;
	private Double preco;
	
	
	public ItemPedido() {

	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		id.setPedidos(pedido);
		id.setProdutos(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedidos();
	}

	public void setPedido(Pedido pedido) {
		id.setPedidos(pedido);
	}
	
	
	public Produto getProduto() {
		return id.getProdutos();
	}

	public void setProduto(Produto produto) {
		id.setProdutos(produto);
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
	
	public Double getSubTotal() {
		return quantidade * preco;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
}
