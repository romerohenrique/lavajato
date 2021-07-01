package br.com.lavajato.controller;

import br.com.lavajato.model.Cliente;
import br.com.lavajato.model.Veiculo;
import br.com.lavajato.services.VeiculoService;
import br.com.lavajato.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RequestMapping("veiculos")
@RestController
@Log4j2
public class VeiculoController {
    @Autowired
    private final VeiculoService veiculoService;

    @Autowired
    private final DateUtil dateUtil;

    @GetMapping(path = "/teste")
    public String check() {
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return "ola´página";
    }


    @PostMapping(path = "/cadastrar")
    public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(veiculoService.save(veiculo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> delete(@PathVariable Integer id) {
        veiculoService.delete(id);
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


