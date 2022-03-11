package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.domain.model.Caminhao;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.repository.CaminhaoRepository;


@Service
public class CaminhaoService {

	@Autowired
	private CaminhaoRepository caminhaoRepository;

	public List<Caminhao> obterLista() {
		return caminhaoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<Caminhao> obterLista(Usuario usuario) {
		return caminhaoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "id"));
	}

	public void incluir(Caminhao caminhao) {
		caminhaoRepository.save(caminhao);
	}

	public void excluir(Integer id) {
		caminhaoRepository.deleteById(id);
	}

	public Caminhao obterPorId(Integer id) {
		return caminhaoRepository.findById(id).orElse(null);
	}

	public Long obterQtd() {

		return caminhaoRepository.count();
	}
}