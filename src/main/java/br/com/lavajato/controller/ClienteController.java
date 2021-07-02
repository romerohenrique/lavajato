package br.com.lavajato.controller;

import br.com.lavajato.model.Cliente;
import br.com.lavajato.services.ClienteService;
import br.com.lavajato.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("clientes")
@AllArgsConstructor
@Log4j2
public class ClienteController {

    @Autowired
    private final DateUtil dateUtil;

    @Autowired
    private final ClienteService clienteService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping(path = "nome/{nome}")
    public ResponseEntity<Cliente> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(clienteService.findByName(nome));
    }

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> replace(@RequestBody Cliente cliente) {
        clienteService.replace(cliente);
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
        log.info("Deletando usuário {}", dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        clienteService.delete(id);
        log.info("usuário deletado {}", dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
