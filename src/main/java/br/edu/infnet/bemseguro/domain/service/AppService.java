package br.edu.infnet.bemseguro.domain.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	
	@Autowired
	private ApoliceService apoliceService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private SeguradoService seguradoService;
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private MotocicletaService motocicletaService;
	
	@Autowired
	private CaminhaoService caminhaoService;
	

	@SuppressWarnings("rawtypes")
	public Map qtds () {
		
		Map<String, Long> mapa = new HashMap<>();
		mapa.put("Usuários", usuarioService.obterQtd());
		mapa.put("Segurados", seguradoService.obterQtd());
		mapa.put("Veiculos", veiculoService.obterQtd());
		mapa.put("Carros", carroService.obterQtd());
		mapa.put("Motocicletas", motocicletaService.obterQtd());
		mapa.put("Caminhões", caminhaoService.obterQtd());
		mapa.put("Apolices",apoliceService.obterQtd());

		return mapa;
		
	}
	
	
}
