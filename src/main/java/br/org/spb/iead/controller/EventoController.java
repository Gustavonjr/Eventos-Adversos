package br.org.spb.iead.controller;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.Evento;
import br.org.spb.iead.model.Problema;
import br.org.spb.iead.model.Setor;
import br.org.spb.iead.repository.ProblemaRepository;
import br.org.spb.iead.repository.SetorRepository;
import br.org.spb.iead.service.ConfigService;
import br.org.spb.iead.service.EventoService;
import br.org.spb.iead.util.EnviarEmail;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Controller
@AllArgsConstructor
public class EventoController {

    EventoService eventoService;

    ProblemaRepository problemaRepository;

    SetorRepository setorRepository;

    ConfigService configService;

    EnviarEmail email;


    @RequestMapping(value = "/eventos",method = RequestMethod.GET)
    public ModelAndView getEventos(){
        ModelAndView mv = new ModelAndView("eventos");
        List<Evento> eventos = eventoService.findAll();
        eventos.sort(Comparator.comparing(Evento::getId, Comparator.reverseOrder()));
        mv.addObject("eventos",eventos);

        Config config = configService.findById(1);
        mv.addObject("config", config);
        System.out.println("/eventos acessado");
        return mv;
    }

    // Mapeamento para a URL "/eventosJs" usando a anotação @GetMapping

    @GetMapping(value = "/eventosJs", produces = "application/json")
    @ResponseBody // Esta anotação é necessária para informar ao Spring que o retorno deve ser serializado como corpo da resposta (JSON)
    public ResponseEntity<List<Evento>> getEventosJs() {
        List<Evento> eventos = eventoService.findAll();
        eventos.sort(Comparator.comparing(Evento::getId, Comparator.reverseOrder()));
        System.out.println("/eventosJs acessado");

        // Define o cabeçalho Content-Type como application/json e retorna a lista de eventos
        return ResponseEntity.ok().body(eventos);
    }

    @RequestMapping(value = "/eventosJs/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Evento> getEventoJsId(@PathVariable("id") long id){
        Evento evento = eventoService.findById(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

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
    @RequestMapping(value = "/eventosPorData", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getEventosPorData() {
        List<Evento> eventos = eventoService.findAll();
        Map<String, Integer> countByYearMonth = new HashMap<>();

        for (Evento evento : eventos) {
            String data = evento.getData();
            String yearMonth = data.substring(0, 7); // Extrai somente o ano e o mês (yyyy-MM)
            countByYearMonth.put(yearMonth, countByYearMonth.getOrDefault(yearMonth, 0) + 1);
        }

        // Ordena o mapa por chave (ano e mês)
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        countByYearMonth.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return new ResponseEntity<>(sortedMap, HttpStatus.OK);
    }

    @RequestMapping(value="/eventos/{id}", method=RequestMethod.GET)
    public ModelAndView getEventoDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("eventoDetails");
        Evento evento = eventoService.findById(id);
        mv.addObject("evento", evento);
        Config config = configService.findById(1);
        mv.addObject("config", config);
        System.out.println("/eventos/id acessado");
        return mv;
    }


    @RequestMapping(value = "/gerenciar", method = RequestMethod.GET)
    public String getGerentiar(){
        return "gerenciarEventos";
    }
    @RequestMapping(value = "/novoevento", method = RequestMethod.GET)
    public ModelAndView getEventoForm(){
        ModelAndView mv = new ModelAndView("eventoForm");
        Config config = configService.findById(1);
        mv.addObject("config", config);
        return mv;
    }

    @RequestMapping(value ="/novoevento", method = RequestMethod.POST)
    public String savePost(@Valid Evento evento, @RequestParam("setorOcorrencia.setor") String setorOcorrencia,
                           @RequestParam("setorNotificante.setor") String setorNotificante, BindingResult result, RedirectAttributes attributes){
        if(evento.getNomeColaborador().isBlank()){
            evento.setNomeColaborador("Anonimo");
        }

        Setor setorN = setorRepository.findBySetor(setorNotificante);
        Setor setorO = setorRepository.findBySetor(setorOcorrencia);

        System.out.println(setorNotificante + setorOcorrencia);

        evento.setSetorNotificante(setorN);
        evento.setSetorOcorrencia(setorO);
        evento.setResolvido("Não Verificado");
        evento.setDataSys(LocalDate.now());

        eventoService.save(evento);

        email.enviarEmail(evento,"");
        return "redirect:/";
    }

    @RequestMapping(value = "/eventos/{id}/enviarPara", method = RequestMethod.POST)
    public String enviarEmailPara(@PathVariable("id") long id, @RequestParam("enviarPara") String destinatario ){
        Evento evento = eventoService.findById(id);

        email.enviarEmail(evento, destinatario);
        return "redirect:/eventos/" +id;
    }

    @RequestMapping(value = "/eventos/{id}/update", method = RequestMethod.POST)
    public String updateEvento(@PathVariable("id") long id,  @RequestParam("problema.problema") String problema ) {
        Evento evento = eventoService.findById(id);
        Problema problema1 = problemaRepository.findByProblema(problema);
        evento.setProblema(problema1);
            evento.setDataClassificacaoUpdate(LocalDate.now());
            evento.setHoraClassificacaoUpdate(LocalTime.now());

        evento.setProblema(problema1);
        eventoService.save(evento);
        return "redirect:/eventos/" +id;
    }

    @RequestMapping(value = "/eventos/{id}/updateR", method = RequestMethod.POST)
    public String updateEventoR(@PathVariable("id") long id, @RequestParam("resolvido") String resolvido ) {
        Evento evento = eventoService.findById(id);

        if(!resolvido.equals(evento.getResolvido())){
            evento.setDataResolvidoUpdate(LocalDate.now());
            evento.setHoraResolvidoUpdate(LocalTime.now());
            evento.setResolvido(resolvido);
        }
        eventoService.save(evento);
        return "redirect:/eventos/" +id;
    }
    }
