package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.eventos.TipoEventoModel;
import br.org.spb.iead.service.TipoEventoService;
import br.org.spb.iead.service.serviceImp.ConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TipoEventoController {

    @Autowired
    TipoEventoService tipoEventoService;

    @Autowired
    ConfigServiceImpl configService;

    @RequestMapping(value = "/tiposEventos", method = RequestMethod.GET)
    public ResponseEntity<List<TipoEventoModel>> getTiposEventos() {
        List<TipoEventoModel> tipoEventos = tipoEventoService.findAll();
        return new ResponseEntity<>(tipoEventos, HttpStatus.OK);
    }

    @RequestMapping(value = "/eventosConfig", method = RequestMethod.GET)
    public ModelAndView tiposEventos(){
        ModelAndView mv = new ModelAndView("TipoEvento");
        List<TipoEventoModel> tiposEventos = tipoEventoService.findAll();
        Config config = configService.findById(1);

        mv.addObject("tiposEventos", tiposEventos);
        mv.addObject("config", config);
        return mv;
    }

    @RequestMapping(value = "/novotipoevento", method = RequestMethod.POST)
    public String saveTipoEvento(@Valid TipoEventoModel tipoEvento){
        tipoEventoService.save(tipoEvento);
        return "redirect:/eventosConfig";
    }



}
