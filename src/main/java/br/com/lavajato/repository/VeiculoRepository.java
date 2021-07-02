package br.com.lavajato.repository;

import br.com.lavajato.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {

    @Query(nativeQuery = true, value = "select * from veiculo where cliente_id = ?1")
    List<Veiculo> findAllByVeiculoId(Integer id);
}

