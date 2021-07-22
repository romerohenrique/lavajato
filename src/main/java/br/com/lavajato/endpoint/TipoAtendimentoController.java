package br.com.lavajato.endpoint;

import br.com.lavajato.entity.TipoAtendimento;
import br.com.lavajato.services.TipoAtendimentoService;
import br.com.lavajato.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RequestMapping("atendimentos")
@RestController
public class TipoAtendimentoController {


    private final TipoAtendimentoService tipoAtendimentoService;

    @Autowired
    public TipoAtendimentoController(TipoAtendimentoService tipoAtendimentoService) {
        this.tipoAtendimentoService = tipoAtendimentoService;
    }

    @PostMapping(value = "/registro")
    public ResponseEntity<String> save(@RequestBody TipoAtendimento tipoAtendimento) {
        log.info("Salvando atendimento {}", DateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        tipoAtendimentoService.save(tipoAtendimento);
        log.info("Atendimento salvo {}", DateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body("Salvo com sucesso");
    }
}
