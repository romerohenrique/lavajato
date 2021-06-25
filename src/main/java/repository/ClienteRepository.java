package repository;

import model.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    List<Cliente> findByName(String nome);
    Optional<Object> findAll(Cliente cliente);
}
