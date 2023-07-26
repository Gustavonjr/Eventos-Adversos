package br.org.spb.iead.controller;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.model.Problema;
import br.org.spb.iead.model.Processo;
import br.org.spb.iead.model.TipoEvento;
import br.org.spb.iead.repository.TipoEventoRepository;
import br.org.spb.iead.service.ProcessoService;
import br.org.spb.iead.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class ProcessoController {

    @Autowired
    ProcessoService processoService;

    @Autowired
    TipoEventoService tipoEventoService;

    @RequestMapping(value = "/processos", method = RequestMethod.GET)
    public ResponseEntity<List<Processo>> getProcessos(){
        List<Processo> listProcesso = processoService.findAll();
        return new ResponseEntity<>(listProcesso, HttpStatus.OK);
    }

    @RequestMapping(value = "/novoprocesso", method = RequestMethod.POST)
    public String saveProcesso(@RequestBody @Valid Processo processo, BindingResult result, RedirectAttributes attributes){
        String tipoEventoNome = processo.getTipoEvento().getTipoEvento();
        TipoEvento tipoEvento = tipoEventoService.findByTipoEvento(tipoEventoNome);

        processo.setTipoEvento(tipoEvento);
        processoService.save(processo);
        return "redirect:/processos";
    }


}
