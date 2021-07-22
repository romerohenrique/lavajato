package br.com.lavajato.services;

import br.com.lavajato.entity.TipoAtendimento;
import br.com.lavajato.enums.TipoAtendimentoEnum;
import br.com.lavajato.repository.TipoAtendimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoAtendimentoService {

    //private final ClienteRepository clienteRepository;
    //private final VeiculoRepository veiculoRepository;
    private final TipoAtendimentosRepository tipoAtendimentosRepository;


    @Autowired
    public TipoAtendimentoService(TipoAtendimentosRepository tipoAtendimentosRepository) {
        this.tipoAtendimentosRepository = tipoAtendimentosRepository;
    }

    public TipoAtendimento save(TipoAtendimento tipoAtendimento) {

        tipoAtendimento.setIdCliente(1);
        tipoAtendimento.setIdVeiculo(4);
        tipoAtendimento.setTipoAtendimentoEnum(TipoAtendimentoEnum.CARRO_LAVAGEM);
        tipoAtendimento.setPreco(tipoAtendimento.getTipoAtendimentoEnum().getPreco());
        return tipoAtendimentosRepository.save(tipoAtendimento);
    }

}
