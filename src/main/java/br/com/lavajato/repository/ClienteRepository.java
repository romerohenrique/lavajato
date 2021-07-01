package br.com.lavajato.repository;

import br.com.lavajato.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Optional<Cliente> findByNome(String nome);
}
