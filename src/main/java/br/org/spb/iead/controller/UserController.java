package br.org.spb.iead.controller;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.model.Setor;
import br.org.spb.iead.model.UserModel;
import br.org.spb.iead.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getUsuarios() {
        List<UserModel> usuarios = userService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuariosForm", method = RequestMethod.GET)
    public String getUsuariosForm() {
        return "cadastrarUser";
    }


    //TODO NÃO ESTÁ ENVIANDO AS ROLES EM FORMATO DE LISTA, POREM, ESTÁ FUNCIONANDO O GERENCIAMENTO DO WEB SECURITY
    @RequestMapping(value = "/usuariosForm", method = RequestMethod.POST)
    public String saveUsuario(@Valid UserModel userModel, BindingResult result, RedirectAttributes attributes){
        System.out.println("usuario:");
        System.out.println(userModel.toString());
        //userService.save(userModel);
        return "redirect:/usuarios";
    }

}
