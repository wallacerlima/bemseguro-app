package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.client.ISeguradoClient;
import br.edu.infnet.bemseguro.domain.model.Segurado;
import br.edu.infnet.bemseguro.domain.model.Usuario;

@Service
public class SeguradoService {
	
	@Autowired
	private ISeguradoClient seguradoClient;

	public List<Segurado> obterLista(){

		return (List<Segurado>) seguradoClient.obterLista();
	}
	
	public List<Segurado> obterLista(Usuario usuario){

		return seguradoClient.obterListaPorUser(usuario.getId());
	}

	public void incluir(Segurado segurado) {

		seguradoClient.incluir(segurado);
	}
	
	public void excluir(Integer id) {

		seguradoClient.excluir(id);
	}
	
	public Segurado obterPorId(Integer id) {
		return seguradoClient.obterPorId(id);
	}
	
	public Integer obterQtd() {
		return seguradoClient.obterLista().size();
	}
}