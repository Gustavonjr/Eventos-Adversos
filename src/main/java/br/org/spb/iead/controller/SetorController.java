package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.Setor;
import br.org.spb.iead.service.ConfigService;
import br.org.spb.iead.service.SetorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class SetorController {

    SetorService setorService;

    ConfigService configService;


    @RequestMapping(value = "/setores", method = RequestMethod.GET)
    public ResponseEntity<List<Setor>> getSetores() {
        List<Setor> setores = setorService.findAll();
        return new ResponseEntity<>(setores, HttpStatus.OK);
    }

    @RequestMapping(value = "/setoresConfig", method = RequestMethod.GET)
    public ModelAndView setores(){
        ModelAndView mv = new ModelAndView("Setores");
        List<Setor> setores = setorService.findAll();
        mv.addObject("setores",setores);

        Config config = configService.findById(1);
        mv.addObject("config", config);

        return mv;
    }

    @RequestMapping(value ="/setoresConfig", method = RequestMethod.POST)
    public String saveSetor(@ModelAttribute @Valid Setor setor){
        setorService.save(setor);
        return "redirect:/setoresConfig";
    }


}
