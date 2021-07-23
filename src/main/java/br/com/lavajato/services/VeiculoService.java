package br.com.lavajato.services;

import br.com.lavajato.entity.Cliente;
import br.com.lavajato.entity.Veiculo;
import br.com.lavajato.repository.ClienteRepository;
import br.com.lavajato.repository.VeiculoRepository;
import br.com.lavajato.services.exceptionerror.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class VeiculoService {

    @Autowired
    private final VeiculoRepository veiculoRepository;
    @Autowired
    private final ClienteService clienteService;
    @Autowired
    private final ClienteRepository clienteRepository2;

    public Veiculo finById(Integer id) {
        return veiculoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Id not found " + id));
    }

    public Veiculo save(Veiculo veiculo) {
        try {
            Cliente cliente = clienteService.findById(15);
            veiculo.setCliente(cliente);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return veiculoRepository.save(veiculo);
    }

    public void delete(Integer id) {
        veiculoRepository.delete(finById(id));
    }

    public Iterable<Veiculo> findAllVeiculos() {
        return veiculoRepository.findAll();
    }
}
