package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.eventos.Evento;
import br.org.spb.iead.model.informatica.ChamadoVivo;
import br.org.spb.iead.service.ChamadoVivoService;
import br.org.spb.iead.service.ConfigService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@Lazy
public class ChamadoVivoController {

    ChamadoVivoService chamadoVivoService;
    ConfigService configService;

    @RequestMapping(value = "/chamadosVivo", method = RequestMethod.GET)
    public ModelAndView getEventos(){
        ModelAndView mv = new ModelAndView("chamadosVivo");
        List<ChamadoVivo> chamadosVivo = chamadoVivoService.findAll();
        mv.addObject("chamadosVivo",chamadosVivo);


        Config config = configService.findById(1);
        mv.addObject("config", config);
        return mv;
    }
}
