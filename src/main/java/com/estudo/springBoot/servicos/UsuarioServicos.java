package com.estudo.springBoot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.springBoot.entidades.Usuario;
import com.estudo.springBoot.repositorios.UsuarioRepositorios;

@Service
public class UsuarioServicos {
 
	@Autowired
	private UsuarioRepositorios ur;
	
	public List<Usuario> buscarPorUsuarios(){
		return ur.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = ur.findById(id);
		return obj.get();
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		return ur.save(usuario);
	}
	
	public void deletar(Long id) {
		ur.deleteById(id);
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
