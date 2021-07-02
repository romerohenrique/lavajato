package br.com.lavajato.services;

import br.com.lavajato.model.Cliente;
import br.com.lavajato.model.Veiculo;
import br.com.lavajato.repository.VeiculoRepository;
import br.com.lavajato.services.exceptionerror.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteService clienteService;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, ClienteService clienteService) {
        this.veiculoRepository = veiculoRepository;
        this.clienteService = clienteService;
    }

    public Veiculo finById(Integer id) {
        return veiculoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Id not found" + id));
    }

    public Veiculo save(Veiculo veiculo) {
        Cliente cliente = clienteService.findById(1);

        veiculo.setCliente(cliente);
        return veiculoRepository.save(veiculo);
    }

    public void delete(Integer id) {
        veiculoRepository.delete(finById(id));
    }

    public List<Veiculo> findAllVeiculos(final Integer id) {
        return veiculoRepository.findAllByVeiculoId(id);
    }
}
