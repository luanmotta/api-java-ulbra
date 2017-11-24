package br.edu.ulbra.gestaovinhos.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ulbra.gestaovinhos.input.UserInput;
import br.edu.ulbra.gestaovinhos.model.User;
import br.edu.ulbra.gestaovinhos.repository.UserRepository;

@Controller
@RequestMapping("/admin/usuario")
public class AdminUserController {
	
	@Autowired
    UserRepository userRepository;
	
	private ModelMapper mapper = new ModelMapper();

    private ModelAndView userForm(UserInput userInput){
        ModelAndView mv = new ModelAndView("admin/usuario/novo");
        mv.addObject("user", userInput);
        return mv;
    }

    @GetMapping("/lista")
    public ModelAndView listaUsuarios(){
        ModelAndView mv = new ModelAndView("admin/usuario/lista");
        List<User> users = (List<User>) userRepository.findAll();
        mv.addObject("usuarios", users);
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novoUsuarioForm(){
    	return this.userForm(new UserInput());
    }

    @PostMapping("/novo")
    public ModelAndView novoUsuario(UserInput userInput){
        if (userInput.getPassword() != null && userInput.getPassword().length() > 0 && !userInput.getPassword().equals(userInput.getPasswordConfirm())){
            ModelAndView mv = this.userForm(userInput);
            mv.addObject("error", "Password don't match!");
            return mv;
        }

        User user = mapper.map(userInput, User.class);
        userRepository.save(user);
        return new ModelAndView("redirect:/admin/usuario/lista");
    }

    @GetMapping("/{id}")
    public String detalheUsuario(@PathVariable("id") Long idUsuario){
        return "admin/usuario/detalhe";
    }

    @PostMapping("/{id}")
    public String salvarUsuario(@PathVariable("id") Long idUsuario){
        return "redirect:/admin/usuario";
    }

    @PostMapping("/{id}/resetSenha")
    public String resetarSenhaUsuario(@PathVariable("id") Long idUsuario){
        return "redirect:/admin/usuario/" + idUsuario;
    }
    
    @GetMapping("/{id}/excluir")
    public ModelAndView deleteUserDemo(@PathVariable(name="id") Long id){
        User usuario = userRepository.findOne(id);
        userRepository.delete(usuario);
        return new ModelAndView("redirect:/demo/user/?usercreated=true");

    }


}
