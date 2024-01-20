package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.eventos.ProcessoModel;
import br.org.spb.iead.model.eventos.TipoEventoModel;
import br.org.spb.iead.service.ProcessoService;
import br.org.spb.iead.service.TipoEventoService;
import br.org.spb.iead.service.serviceImp.ConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProcessoController {

    @Autowired
    ProcessoService processoService;

    @Autowired
    TipoEventoService tipoEventoService;

    @Autowired
    ConfigServiceImpl configService;

    @RequestMapping(value = "/processos", method = RequestMethod.GET)
    public ResponseEntity<List<ProcessoModel>> getProcessos(){
        List<ProcessoModel> listProcesso = processoService.findAll();
        return new ResponseEntity<>(listProcesso, HttpStatus.OK);
    }

    @RequestMapping(value = "/processoConfig", method = RequestMethod.GET)
    public ModelAndView processoConfig(){
        ModelAndView mv = new ModelAndView("Processos");
        Config config = configService.findById(1);
        List<ProcessoModel> processoModels  = processoService.findAll();

        mv.addObject("config",config);
        mv.addObject("processoModels",processoModels);

        return mv;
    }

    @RequestMapping(value = "/novoprocesso", method = RequestMethod.POST)
    public String saveProcesso(@RequestBody @Valid ProcessoModel processo, BindingResult result, RedirectAttributes attributes){
        String tipoEventoNome = processo.getTipoEvento().getTipoEvento();
        TipoEventoModel tipoEvento = tipoEventoService.findByTipoEvento(tipoEventoNome);

        processo.setTipoEvento(tipoEvento);
        processoService.save(processo);
        return "redirect:/processos";
    }


}
