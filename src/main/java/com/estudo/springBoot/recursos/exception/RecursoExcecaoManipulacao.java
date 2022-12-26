package com.estudo.springBoot.recursos.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudo.springBoot.servicos.excecao.ExcecaoDoBancoDeDados;
import com.estudo.springBoot.servicos.excecao.RecursoNaoFoiEncontradoException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RecursoExcecaoManipulacao {
	
	@ExceptionHandler(RecursoNaoFoiEncontradoException.class)
	public ResponseEntity<StandardError> recursosNaoEncontrados(RecursoNaoFoiEncontradoException e, HttpServletRequest request){
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
		
	@ExceptionHandler(ExcecaoDoBancoDeDados.class)
	public ResponseEntity<StandardError> BancoDeDados(ExcecaoDoBancoDeDados e, HttpServletRequest request){
		String error = "Erro no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
