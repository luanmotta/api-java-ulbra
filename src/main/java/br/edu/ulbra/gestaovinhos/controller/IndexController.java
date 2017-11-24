package br.edu.ulbra.gestaovinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ulbra.gestaovinhos.model.Vinho;
import br.edu.ulbra.gestaovinhos.repository.VinhoRepository;

import java.util.List;

@Controller
public class IndexController {
	
	@Autowired
	VinhoRepository vinhoRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/inicio")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("/inicio");
        List<Vinho> vinhos = (List<Vinho>) vinhoRepository.findAll();
        mv.addObject("vinhos", vinhos);
        return mv;
    }
}
