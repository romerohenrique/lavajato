package br.com.lavajato.services;

import br.com.lavajato.entity.Cliente;
import br.com.lavajato.repository.ClienteRepository;
import br.com.lavajato.repository.VeiculoRepository;
import br.com.lavajato.services.exceptionerror.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
A classe Service, ficam as regras de negócio
 */
@Service
public class ClienteService {


    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
    }

//    public List<Cliente> findAll(){
//
//        return clienteRepository.findAll();
//    }

    public void replace(Cliente cliente) {
        clienteRepository.findById(cliente.getId()).orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado"));
        clienteRepository.save(cliente);

    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Id não encontrado" + id));
    }

    public Cliente findByName(String nome) {
        return clienteRepository.findByNome(nome).orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado" + nome));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Antes de deletar cliente é necessário deletar veículos relacionados ao Cliente
     *
     * @param id do cliente a ser deletado
     */
    public void delete(Integer id) {
        veiculoRepository.findAllByVeiculoId(id).forEach(veiculoRepository::delete);
        clienteRepository.delete(findById(id));
    }
}
