package br.edu.infnet.bemseguro.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bemseguro.domain.model.Carro;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {

	@Query("from Carro c where c.usuario.id = :userid")
	List<Carro> findAll(Integer userid, Sort by);
	
	List<Carro> findAll(Sort by);

}
