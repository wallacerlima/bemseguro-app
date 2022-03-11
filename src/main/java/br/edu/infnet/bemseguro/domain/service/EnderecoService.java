package br.edu.infnet.bemseguro.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.client.IEnderecoClient;
import br.edu.infnet.bemseguro.domain.model.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Endereco obterPorCep(String cep) {
	
		return enderecoClient.buscarCep(cep);
	}
}
