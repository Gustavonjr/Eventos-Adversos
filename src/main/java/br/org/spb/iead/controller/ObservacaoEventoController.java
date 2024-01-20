package br.org.spb.iead.controller;

import br.org.spb.iead.model.eventos.Evento;
import br.org.spb.iead.model.eventos.ObservacaoEvento;
import br.org.spb.iead.repository.ObservacaoEventoRepository;
import br.org.spb.iead.service.serviceImp.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ObservacaoEventoController {

    @Autowired
    ObservacaoEventoRepository observacaoEventoService;

    @Autowired
    EventoServiceImpl eventoService;

    @RequestMapping(value = "/observacao", method = RequestMethod.GET)
    public ResponseEntity<List<ObservacaoEvento>> getObservacao(){
        List<ObservacaoEvento> observacaoEventos = observacaoEventoService.findAll();
        return new ResponseEntity<>(observacaoEventos, HttpStatus.OK);
    }

    @RequestMapping(value = "/observacao/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ObservacaoEvento>> getObservacaoEvento(@PathVariable("id") long id){
        List<ObservacaoEvento> observacaoEventos = observacaoEventoService.findByEventoId(id);
        return new ResponseEntity<>(observacaoEventos, HttpStatus.OK);
    }

    @RequestMapping(value = "/observacao/{id}", method = RequestMethod.POST)
    public String novaObservacao(@Valid ObservacaoEvento observacaoEvento, @PathVariable long id){
        Evento evento = eventoService.findById(id);
        observacaoEvento.setDataObservacao(LocalDateTime.now());


        observacaoEvento.setEvento(evento);
        observacaoEventoService.save(observacaoEvento);
        return "redirect:/eventos/"+id;
    }
}
