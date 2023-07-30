package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex(){
        ModelAndView mv = new ModelAndView("index");
        Config config = configService.findById(1);
        mv.addObject("config", config);
        return mv;

    }
}
