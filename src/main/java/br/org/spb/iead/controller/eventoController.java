package br.org.spb.iead.controller;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Controller
public class eventoController {

    @Autowired
    EventoService eventoService;

    @RequestMapping(value = "/eventos",method = RequestMethod.GET)
    public ModelAndView getEventos(){
        ModelAndView mv = new ModelAndView("eventos");
        List<Evento> eventos = eventoService.findAll();
        eventos.sort(Comparator.comparing(Evento::getId, Comparator.reverseOrder()));
        mv.addObject("eventos",eventos);
        return mv;
    }

//    Metodo para ver como que fica no json sem visualizar o html
@RequestMapping(value = "/resolvidos", method = RequestMethod.GET)
public ResponseEntity<Map<String, Integer>> getResolvidos() {
    List<Evento> eventos = eventoService.findAll();
    Map<String, Integer> countByClassification = new HashMap<>();

    for (Evento evento : eventos) {
        String resolvido = evento.getResolvido();
        countByClassification.put(resolvido, countByClassification.getOrDefault(resolvido, 0) + 1);
    }

    return new ResponseEntity<>(countByClassification, HttpStatus.OK);
}
    @RequestMapping(value="/eventos/{id}", method=RequestMethod.GET)
    public ModelAndView getEventoDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("eventoDetails");
        Evento evento = eventoService.findById(id);
        mv.addObject("evento", evento);
        return mv;
    }

    @RequestMapping(value = "/novoevento", method = RequestMethod.GET)
    public String getEventoForm(){
        return "eventoForm";
    }

    @RequestMapping(value ="/novoevento", method = RequestMethod.POST)
    public String savePost(@Valid Evento evento, BindingResult result, RedirectAttributes attributes){
        if(evento.getNomeColaborador().isBlank()){
            evento.setNomeColaborador("Anonimo");
        }
        evento.setDataSys(LocalDate.now());
        evento.setResolvido("Não Verificado");
        eventoService.save(evento);
        return "redirect:/eventos";
    }

    @RequestMapping(value = "/eventos/{id}/update", method = RequestMethod.POST)
    public String updateEvento(@PathVariable("id") long id, @RequestParam("resolvido") String resolvido) {
        Evento evento = eventoService.findById(id);
        evento.setResolvido(resolvido);
        evento.setDataResolvidoUpdate(LocalDate.now());
        evento.setHoraResolvidoUpdate(LocalTime.now());
        eventoService.save(evento);
        return "redirect:/eventos/";
    }




}
