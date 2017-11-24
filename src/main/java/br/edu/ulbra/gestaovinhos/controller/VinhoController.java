package br.edu.ulbra.gestaovinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ulbra.gestaovinhos.model.Vinho;
import br.edu.ulbra.gestaovinhos.input.AvaliarInput;
import br.edu.ulbra.gestaovinhos.input.VinhoInput;
import br.edu.ulbra.gestaovinhos.model.Avaliacao;
import br.edu.ulbra.gestaovinhos.model.User;
import br.edu.ulbra.gestaovinhos.repository.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vinhos")
public class VinhoController {
	
	@Autowired
	VinhoRepository vinhoRepository;
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	UserRepository userRepository;

    private ModelAndView avaliarForm(AvaliarInput avaliarInput){
        ModelAndView mv = new ModelAndView("vinhos/avaliar");
        mv.addObject("avaliarInput", avaliarInput);
        return mv;
    }

    @RequestMapping("/minhalista")
    public ModelAndView minhaLista() {
        ModelAndView mv = new ModelAndView("vinhos/minhalista");
        List<Avaliacao> avaliacoes = (List<Avaliacao>) avaliacaoRepository.findAll();
        mv.addObject("avaliacoes", avaliacoes);
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView detalhe(@PathVariable("id") Long idVinho){
        ModelAndView mv = new ModelAndView("vinhos/detalhe");
        Vinho vinho = vinhoRepository.findOne(idVinho);
        mv.addObject("vinho", vinho);
        return mv;
    }

    @GetMapping("/{id}/avaliar")
    public ModelAndView avaliar(@PathVariable("id") Long idVinho){
    	Vinho vinho = vinhoRepository.findOne(idVinho);

        ModelAndView mv = this.avaliarForm(new AvaliarInput());
        mv.addObject("vinho", vinho);
        return mv;
    }

    @PostMapping("/{id}/avaliar")
    public ModelAndView enviarAvaliacao(@PathVariable("id") Long id, AvaliarInput avaliarInput){
    	Vinho vinho = vinhoRepository.findOne(id);
    	Avaliacao avaliacao = new Avaliacao();
    	
    	avaliacao.setDescricao(avaliarInput.getDescricao());
    	avaliacao.setDateTime(new Date());
    	avaliacao.setPositivo(true);
    	avaliacao.setVinho(vinho);
    	avaliacao.setUser(userRepository.findOne((long) 1));
        
        avaliacaoRepository.save(avaliacao);
    	return new ModelAndView("redirect:/vinhos/" + id);
    }

}

