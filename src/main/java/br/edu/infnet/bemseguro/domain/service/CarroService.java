package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.client.ICarroClient;
import br.edu.infnet.bemseguro.domain.model.Carro;
import br.edu.infnet.bemseguro.domain.model.Usuario;

@Service
public class CarroService {

	@Autowired
	private ICarroClient carroClient;

	public List<Carro> obterLista() {
		return carroClient.obterLista();
	}

	public List<Carro> obterLista(Usuario usuario) {
		 return carroClient.obterLista(usuario.getId());
	}

	public void incluir(Carro carro) {
		carroClient.incluir(carro);
	}

	public void excluir(Integer id) {
		carroClient.excluir(id);
	}

	public Carro obterPorId(Integer id) {
		return carroClient.obterPorId(id);
	}

	public Integer obterQtd() {
		return carroClient.obterLista().size();
	}
}