package br.edu.ulbra.gestaovinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/usuario")
public class VinhoController {

    @GetMapping("/novo")
    @PostMapping("/novo")
    public String novoUsuario(){
        return "usuario/novoUsuario";
    }

}
