package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.RoleModel;
import br.org.spb.iead.model.SetorModel;
import br.org.spb.iead.model.UserModel;
import br.org.spb.iead.service.ConfigService;
import br.org.spb.iead.service.serviceImp.SetorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class SetorController {

    SetorServiceImpl setorServiceImpl;

    ConfigService configService;


    @RequestMapping(value = "/setores", method = RequestMethod.GET)
    public ResponseEntity<List<SetorModel>> getSetores() {
        List<SetorModel> setores = setorServiceImpl.findAll();
        return new ResponseEntity<>(setores, HttpStatus.OK);
    }

    @RequestMapping(value = "/setoresConfig", method = RequestMethod.GET)
    public ModelAndView setores(){
        ModelAndView mv = new ModelAndView("Setores");
        List<SetorModel> setores = setorServiceImpl.findAll();
        mv.addObject("setores",setores);

        Config config = configService.findById(1);
        mv.addObject("config", config);

        return mv;
    }

    @RequestMapping(value ="/setoresConfig", method = RequestMethod.POST)
    public String saveSetor(@Valid SetorModel setor){
        setorServiceImpl.save(setor);
        return "redirect:/setoresConfig";
    }

}
