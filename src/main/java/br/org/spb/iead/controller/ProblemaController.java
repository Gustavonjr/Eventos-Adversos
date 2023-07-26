package br.org.spb.iead.controller;

import br.org.spb.iead.model.Problema;
import br.org.spb.iead.model.Processo;
import br.org.spb.iead.service.ProblemaService;
import br.org.spb.iead.service.ProcessoService;
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
public class ProblemaController {

    @Autowired
    ProblemaService problemaService;

    @Autowired
    ProcessoService processoService;

    @RequestMapping(value = "/problemas", method = RequestMethod.GET)
    public ResponseEntity<List<Problema>> getProblemas(){
        List<Problema> listaProblemas = problemaService.findAll();
        return new ResponseEntity<>(listaProblemas, HttpStatus.OK);
    }

    @RequestMapping(value = "/novoproblema", method = RequestMethod.POST)
    public String saveProblema(@RequestBody @Valid Problema problema, BindingResult result, RedirectAttributes attributes){
        String processoNome = problema.getProcesso().getProcesso();
        Processo processo = processoService.findByProcesso(processoNome);

        problema.setProcesso(processo);
        problemaService.save(problema);
        return "redirect:/problemas";
    }



}
