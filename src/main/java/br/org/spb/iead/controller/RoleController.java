package br.org.spb.iead.controller;

import br.org.spb.iead.model.RoleModel;
import br.org.spb.iead.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoleController  {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ResponseEntity<List<RoleModel>> getRoles(){
        List<RoleModel> roles = roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);

    }
}
