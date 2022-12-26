package com.estudo.springBoot.servicos.excecao;

public class ExcecaoDoBancoDeDados extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExcecaoDoBancoDeDados(String msg) {
		super(msg);
	}
}
