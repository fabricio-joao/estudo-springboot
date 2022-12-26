package com.estudo.springBoot.entidades.pk;

import java.io.Serializable;
import java.util.Objects;

import com.estudo.springBoot.entidades.Pedido;
import com.estudo.springBoot.entidades.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PedidoItemPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "Pedidos_id")
	private Pedido pedidos;
	
	@ManyToOne
	@JoinColumn(name = "Produtos_id")
	private Produto produtos;
	
	public Pedido getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}
	
	public Produto getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedidos, produtos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItemPK other = (PedidoItemPK) obj;
		return Objects.equals(pedidos, other.pedidos) && Objects.equals(produtos, other.produtos);
	}
}
