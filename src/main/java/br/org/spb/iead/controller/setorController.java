package br.org.spb.iead.controller;

import br.org.spb.iead.model.Setor;
import br.org.spb.iead.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class setorController {

    @Autowired
    SetorService setorService;


    @RequestMapping(value = "/setores", method = RequestMethod.GET)
    public ResponseEntity<List<Setor>> getSetores() {
        List<Setor> setores = setorService.findAll();
        return new ResponseEntity<>(setores, HttpStatus.OK);
    }


}
