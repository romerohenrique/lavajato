package br.com.lavajato.endpoint;

import br.com.lavajato.entity.Veiculo;
import br.com.lavajato.services.VeiculoService;
import br.com.lavajato.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("veiculos")
@RestController
@Log4j2
public class VeiculoController {

    private final VeiculoService veiculoService;
    private final DateUtil dateUtil;

    @Autowired
    public VeiculoController(VeiculoService veiculoService, DateUtil dateUtil) {
        this.veiculoService = veiculoService;
        this.dateUtil = dateUtil;
    }

    @PostMapping(path = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
        log.info("Veiculo criado em {}", dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(veiculoService.save(veiculo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> delete(@PathVariable Integer id) {
        veiculoService.delete(id);
        log.info("deletando veículo {}", dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


