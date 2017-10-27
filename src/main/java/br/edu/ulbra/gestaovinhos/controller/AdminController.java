package br.edu.ulbra.gestaovinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/")
    public String admin(){
        return "admin";
    }

    @PostMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }
    
    /*
     * 
     * Vinhos
     *
     */

    @GetMapping("/vinho")
    public String getVinhos(){
        return "vinho/listar";
    }

    @GetMapping("/vinho/{id}")
    public String getVinhoById(){
        return "vinho/{id}";
    }
    
    @PostMapping("/vinho/{id}")
    public String updateVinhoById(){
        return "vinho/{id}";
    }
    
    @GetMapping("/vinho/novo")
    public String getNewVinho(){
        return "vinho/novo";
    }
    
    @PostMapping("/vinho/novo")
    public String postNewVinho(){
        return "vinho/novo";
    }
}
