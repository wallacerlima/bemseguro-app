package br.edu.infnet.bemseguro.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bemseguro.domain.model.Caminhao;

@Repository
public interface CaminhaoRepository extends CrudRepository<Caminhao, Integer> {

	@Query("from Caminhao c where c.usuario.id = :userid")
	List<Caminhao> findAll(Integer userid, Sort by);
	
	List<Caminhao> findAll(Sort by);

}
