package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.client.IVeiculoClient;
import br.edu.infnet.bemseguro.domain.model.Veiculo;

@Service
public class VeiculoService {

	@Autowired
	private IVeiculoClient veiculoClient;


	public List<Veiculo> obterLista(Integer id) {
		 return veiculoClient.obterLista(id);
	}

	public void excluir(Integer id) {
		veiculoClient.excluir(id);
	}

	public Veiculo obterPorId(Integer id) {

		return veiculoClient.obterPorId(id);
	}

	public Integer obterQtd() {
		return veiculoClient.obterLista().size();
	}

}
