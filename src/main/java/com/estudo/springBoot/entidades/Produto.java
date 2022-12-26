package com.estudo.springBoot.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
 
@Entity 
@Table(name = "Produtos")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgURL;
	
	@ManyToMany
	@JoinTable(name = "Produtos_Categorias", joinColumns = @JoinColumn(name = "Produtos_Id"), inverseJoinColumns = @JoinColumn(name = "Categorias_Id"))
	private Set<Categoria> categorias = new HashSet<>();
	
	@OneToMany(mappedBy = "id.produtos")
	private Set<ItemPedido> itens = new HashSet<>();
	public Produto() {
		
	}

	public Produto(Long id, String nome, String descricao, Double preco, String imgURL) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgURL = imgURL;
	}
	
    @JsonIgnore
	public Set<Pedido> getPedidos() {
		Set<Pedido> set = new HashSet<>();
		for(ItemPedido x: itens) {
			set.add(x.getPedido());
		}
		return set;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
}
