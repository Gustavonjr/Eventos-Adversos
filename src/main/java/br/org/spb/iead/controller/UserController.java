package br.org.spb.iead.controller;

import br.org.spb.iead.configs.security.UserDetailsServiceImpl;
import br.org.spb.iead.configs.security.WebSecurityConfig;
import br.org.spb.iead.model.RoleModel;
import br.org.spb.iead.model.UserModel;
import br.org.spb.iead.repository.RoleRepository;
import br.org.spb.iead.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    WebSecurityConfig webSecurityConfig;


    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getUsuarios() {
        List<UserModel> usuarios = userService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuariosForm", method = RequestMethod.GET)
    public String getUsuariosForm() {
        return "cadastrarUser";
    }



    @RequestMapping(value = "/usuariosForm", method = RequestMethod.POST)
    public String saveUsuario(@Valid UserModel userModel, BindingResult result, RedirectAttributes attributes){
        String roleName = userModel.getRoleModel().getRoleName();
        RoleModel roleModel = roleRepository.findByRoleName(roleName);

        userModel.setPassword(webSecurityConfig.passwordEncoder().encode(userModel.getPassword()));

        userModel.setRoleModel(roleModel);
        userService.save(userModel);
        return "redirect:/usuarios";
    }

}
