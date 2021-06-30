package br.com.lavajato.services;

import br.com.lavajato.model.Cliente;
import br.com.lavajato.repository.ClienteRepository;
import br.com.lavajato.services.exceptionerror.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
A classe Service, ficam as regras de negócio
 */
@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Id not found" + id));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        clienteRepository.delete(findById(id));
    }
}
