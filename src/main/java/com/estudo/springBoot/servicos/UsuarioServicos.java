package com.estudo.springBoot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.repositorios.UsuarioRepositorios;
import com.estudo.springBoot.servicos.excecao.ExcecaoDoBancoDeDados;
import com.estudo.springBoot.servicos.excecao.RecursoNaoFoiEncontradoException;

@Service
public class UsuarioServicos {
 
	@Autowired
	private UsuarioRepositorios ur;
	
	public List<Usuario> buscarPorUsuarios(){
		return ur.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = ur.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoFoiEncontradoException(id));
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		return ur.save(usuario);
	}
	
	public void deletar(Long id) {
		try {
			ur.deleteById(id);
		}
		catch(EmptyResultDataAccessException e){
			throw new RecursoNaoFoiEncontradoException(id);
		}
		catch(RuntimeException e) {
			throw new ExcecaoDoBancoDeDados(e.getMessage());
		}
	}
	
	
	public Usuario atualizar(Long id, Usuario obj) {
		Usuario entidade = ur.getReferenceById(id);
		atualizarInformacoes(entidade, obj);
		return ur.save(entidade);
	}
	
	private void atualizarInformacoes(Usuario usuario, Usuario obj) {
		usuario.setNome(obj.getNome());
		usuario.setEmail(obj.getEmail());
		usuario.setTelefone(obj.getTelefone());
		usuario.setPassword(obj.getPassword()); 
		
		
	}
}
