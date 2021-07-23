package br.com.lavajato.services;

import br.com.lavajato.entity.TipoAtendimento;
import br.com.lavajato.enums.TipoAtendimentoEnum;
import br.com.lavajato.repository.TipoAtendimentosRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TipoAtendimentoService {

    @Autowired
    private final TipoAtendimentosRepository tipoAtendimentosRepository;

    public TipoAtendimento save(TipoAtendimento tipoAtendimento) {

        tipoAtendimento.setIdCliente(1);
        tipoAtendimento.setIdVeiculo(4);
        tipoAtendimento.setTipoAtendimentoEnum(TipoAtendimentoEnum.CARRO_LAVAGEM);
        tipoAtendimento.setPreco(tipoAtendimento.getTipoAtendimentoEnum().getPreco());
        return tipoAtendimentosRepository.save(tipoAtendimento);
    }

}
