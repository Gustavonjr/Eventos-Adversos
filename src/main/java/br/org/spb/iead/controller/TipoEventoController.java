package br.org.spb.iead.controller;

import br.org.spb.iead.model.TipoEvento;
import br.org.spb.iead.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TipoEventoController {

    @Autowired
    TipoEventoService tipoEventoService;

    @RequestMapping(value = "/tiposEventos", method = RequestMethod.GET)
    public ResponseEntity<List<TipoEvento>> getTiposEventos() {
        List<TipoEvento> tipoEventos = tipoEventoService.findAll();
        return new ResponseEntity<>(tipoEventos, HttpStatus.OK);
    }

    @RequestMapping(value = "/novotipoevento", method = RequestMethod.POST)
    public String saveTipoEvento(@RequestBody @Valid TipoEvento tipoEvento, BindingResult result, RedirectAttributes attributes){
        tipoEventoService.save(tipoEvento);
        return "redirect:/processos";
    }



}
