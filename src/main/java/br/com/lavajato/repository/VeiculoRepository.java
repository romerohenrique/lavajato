package br.com.lavajato.repository;

import br.com.lavajato.entity.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {

    @Query(value = "select * from veiculo where cliente_id = ?1", nativeQuery = true)
    List<Veiculo> findAllByVeiculoId(Integer id);
}

