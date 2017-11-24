package br.edu.ulbra.gestaovinhos.controller;

import br.edu.ulbra.gestaovinhos.input.VinhoInput;
import br.edu.ulbra.gestaovinhos.model.Vinho;
import br.edu.ulbra.gestaovinhos.repository.TipoVinhoRepository;
import br.edu.ulbra.gestaovinhos.repository.VinhoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin/vinho")
public class AdminVinhoController {
	
	@Autowired
    VinhoRepository vinhoRepository;
	
	@Autowired
    TipoVinhoRepository tipovinhoRepository;
	
	private ModelMapper mapper = new ModelMapper();

    private ModelAndView vinhoForm(VinhoInput vinhoInput){
        ModelAndView mv = new ModelAndView("admin/vinho/novo");
        mv.addObject("vinho", vinhoInput);
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novoVinhoForm(){
        return this.vinhoForm(new VinhoInput());
    }

    @PostMapping("/novo")
    public ModelAndView novoVinho(VinhoInput vinhoInput){
        if (vinhoInput.getNome() == null || vinhoInput.getNomeImagem() == null) {
            ModelAndView mv = this.vinhoForm(vinhoInput);
            mv.addObject("error", "Nome vazio!");
            return mv;
        }

        Vinho vinho = mapper.map(vinhoInput, Vinho.class);

        vinhoRepository.save(vinho);
        return new ModelAndView("redirect:/admin/inicio");
    }
    
    @GetMapping("/{id}/excluir")
    public ModelAndView deleteUserDemo(@PathVariable(name="id") Long id){
        Vinho vinho = vinhoRepository.findOne(id);
        vinhoRepository.delete(vinho);
        return new ModelAndView("redirect:/admin/inicio");
    }

    @GetMapping("/{id}")
    public ModelAndView detalheVinho(@PathVariable("id") Long id){
    	Vinho vinho = vinhoRepository.findOne(id);
    	VinhoInput vinhoInput = mapper.map(vinho, VinhoInput.class);
    	ModelAndView mv = this.vinhoForm(vinhoInput);
        mv.setViewName("admin/vinho/detalhe");
        
        mv.addObject("avaliacoes", vinho.getAvaliacoes());
    	return mv;
    }

    @PostMapping("/{id}")
    public ModelAndView salvarVinho(@PathVariable("id") Long id, VinhoInput vinhoInput){
    	Vinho vinho = vinhoRepository.findOne(id);
        vinho.setNome(vinhoInput.getNome());
        vinho.setNomeImagem(vinhoInput.getNomeImagem());
        vinho.setVinicola(vinhoInput.getVinicola());
        
        vinhoRepository.save(vinho);
    	return new ModelAndView("redirect:/admin/vinho/inicio");
    }


}
