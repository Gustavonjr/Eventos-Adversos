package br.org.spb.iead.controller;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.repository.ieadRepository;
import br.org.spb.iead.service.IeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class ieadController {

    @Autowired
    IeadService ieadRep;

    @RequestMapping(value = "/eventos",method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("eventos");
        List<Evento> eventos = ieadRep.findAll();
        mv.addObject("eventos",eventos);
        return mv;

    }

    @RequestMapping(value="/eventos/{id}", method=RequestMethod.GET)
    public ModelAndView getEventoDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("eventoDetails");
        Evento evento = ieadRep.findById(id);
        mv.addObject("evento", evento);
        return mv;
    }

}
