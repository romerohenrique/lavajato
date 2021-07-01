package br.com.lavajato.services;

import br.com.lavajato.model.Cliente;
import br.com.lavajato.model.Veiculo;
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

    public Veiculo finById(Integer id) {
        return veiculoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Id not found" + id));
    }

    public Veiculo save(Veiculo veiculo) {

        return veiculoRepository.save(veiculo);
    }
    public void delete(Integer id){
        veiculoRepository.delete(finById(id));
    }
}
