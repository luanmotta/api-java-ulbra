package br.edu.ulbra.gestaovinhos.controller;

import br.edu.ulbra.gestaovinhos.input.UserInput;
import br.edu.ulbra.gestaovinhos.model.User;
import br.edu.ulbra.gestaovinhos.model.Vinho;
import br.edu.ulbra.gestaovinhos.repository.UserRepository;
import br.edu.ulbra.gestaovinhos.repository.VinhoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {
    
	@Autowired
    UserRepository userRepository;

	@Autowired
    VinhoRepository vinhoRepository;

	@GetMapping()
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("admin/index");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("redirect:/admin/inicio");
    }

    @RequestMapping("/inicio")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("admin/inicio");
        List<Vinho> vinhos = (List<Vinho>) vinhoRepository.findAll();
        mv.addObject("vinhos", vinhos);
        return mv;
    }
}
