package com.estudo.springBoot.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.CascadeType;

import com.estudo.springBoot.enuns.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Pedidos")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer pedidoStatus;
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedidos")
	private Set<ItemPedido> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = jakarta.persistence.CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
	
	}
	
	public Pedido(Long id, Instant momento, Usuario cliente, PedidoStatus pedidoStatus) {
		this.id = id;
		this.momento = momento;
		this.cliente = cliente;
		setPedidoStatus(pedidoStatus);
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Instant getMomento() {
		return momento;
	}
	
	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valorOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCodigo();
		}
	}

	public Double getTotal() {
		
		double soma = 0;
		for(ItemPedido x: itens) {
			soma += x.getSubTotal();
		}
		return soma;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}
