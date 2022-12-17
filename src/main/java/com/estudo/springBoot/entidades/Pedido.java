package com.estudo.springBoot.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.estudo.springBoot.enuns.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momentos;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	private Integer status;
	
	public Pedido() {

	}

	public Pedido(Long id, Instant momentos, Usuario cliente, PedidoStatus status) {
		this.id = id;
		this.momentos = momentos;
		this.cliente = cliente;
		setStatus(status);
	}

	public PedidoStatus getStatus() {
		return PedidoStatus.valorOf(status);
	}

	public void setStatus(PedidoStatus status) {
		if(status != null) {
			this.status = status.getCodigo();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomentos() {
		return momentos;
	}

	public void setMomentos(Instant momentos) {
		this.momentos = momentos;
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
