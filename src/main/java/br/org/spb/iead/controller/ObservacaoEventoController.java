package br.org.spb.iead.controller;

import br.org.spb.iead.model.ObservacaoEvento;
import br.org.spb.iead.repository.ObservacaoEventoRepository;
import br.org.spb.iead.service.serviceImp.ObservacaoEventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ObservacaoEventoController {

    @Autowired
    ObservacaoEventoRepository observacaoEventoService;

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
}
