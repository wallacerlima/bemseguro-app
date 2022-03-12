package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.client.IUsuarioClient;
import br.edu.infnet.bemseguro.domain.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioClient usuarioClient;

	public Usuario validar(String email, String senha) {
		return usuarioClient.validar(email, senha);
	}
	
	public void incluir(Usuario usuario) {
		usuarioClient.incluir(usuario);
	}

	public List<Usuario> obterLista() {
		return usuarioClient.obterLista();
	}

	public Usuario obterPorId(Integer id) {
		return usuarioClient.obterPorId(id);
	}

	public void excluir(Integer id) {
		usuarioClient.excluir(id);		
	}
	
	public Integer obterQtd() {
		return usuarioClient.obterLista().size();
	}
}