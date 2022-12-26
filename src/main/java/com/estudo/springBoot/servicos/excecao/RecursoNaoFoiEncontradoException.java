package com.estudo.springBoot.servicos.excecao;

public class RecursoNaoFoiEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RecursoNaoFoiEncontradoException(Object id) {
		super("Recurso não encontardo. ID " + id);
	}
}
