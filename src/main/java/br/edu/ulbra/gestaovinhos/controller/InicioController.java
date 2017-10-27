package br.edu.ulbra.gestaovinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/inicio")
public class VinhoController {

    @GetMapping("/vinho/{id}")
    public String vinhoId(){
        return "inicio/vinhoId";
    }

    @GetMapping("/vinho/{id}/avaliar")
    @PostMapping("/vinho/{id}/avaliar")
    public String vinhoIdAvaliar(){
        return "inicio/vinhoIdAvaliar";
    }

}
