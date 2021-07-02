package br.com.lavajato.repository;

import br.com.lavajato.entity.TipoAtendimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAtendimentosRepository extends CrudRepository<TipoAtendimento, Integer> {

}
