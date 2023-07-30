package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ConfigController {

    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public ModelAndView config(){
        ModelAndView mv = new ModelAndView("config");

        Config config = configService.findById(1);
        mv.addObject("config", config);
        return mv;
    }


    @RequestMapping(value = "/config", method = RequestMethod.POST)
    public String saveConfig(@Valid Config config) {
        config.setId(1);

        configService.save(config);
        return "redirect:/config";
    }

}
