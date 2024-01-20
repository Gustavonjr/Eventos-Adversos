package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.eventos.Evento;
import br.org.spb.iead.service.ConfigService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
@AllArgsConstructor
@Lazy
public class InformaticaController {

    ConfigService configService;
    @RequestMapping(value = "/informatica",method = RequestMethod.GET)
    public ModelAndView informatica(){
        ModelAndView mv = new ModelAndView("informatica");
        Config config = configService.findById(1);
        mv.addObject("config", config);
        System.out.println("/informatica acessado");
        return mv;
    }

}
