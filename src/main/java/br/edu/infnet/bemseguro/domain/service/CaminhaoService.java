package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.client.ICaminhaoClient;
import br.edu.infnet.bemseguro.domain.model.Caminhao;
import br.edu.infnet.bemseguro.domain.model.Usuario;


@Service
public class CaminhaoService {

	@Autowired
	private ICaminhaoClient caminhaoClient;

	public List<Caminhao> obterLista() {
		return caminhaoClient.obterLista();
	}

	public List<Caminhao> obterLista(Usuario usuario) {
		return caminhaoClient.obterLista(usuario.getId());
	}

	public void incluir(Caminhao caminhao) {
		caminhaoClient.incluir(caminhao);
	}

	public void excluir(Integer id) {
		caminhaoClient.excluir(id);
	}

	public Caminhao obterPorId(Integer id) {
		return caminhaoClient.obterPorId(id);
	}

	public Integer obterQtd() {
		return caminhaoClient.obterLista().size();
	}
}