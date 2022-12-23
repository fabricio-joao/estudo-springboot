package com.estudo.springBoot.entidades.pk;

import java.io.Serializable;
import java.util.Objects;

import com.estudo.springBoot.entidades.Pedido;
import com.estudo.springBoot.entidades.Produtos;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PedidosPorItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne 
	@JoinColumn(name = "Pedido_id")
	private Pedido pedido;
	
	@ManyToOne 
	@JoinColumn(name = "Produtos_id")
	private Produtos produtos;

	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, produtos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidosPorItemPK other = (PedidosPorItemPK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produtos, other.produtos);
	}
}
