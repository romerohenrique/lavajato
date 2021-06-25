package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeiculoController {

    @GetMapping(path = "/teste")
    public String check(){
        return "ola´página";
    }
}
