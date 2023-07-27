package br.org.spb.iead.controller;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.model.Problema;
import br.org.spb.iead.model.RoleModel;
import br.org.spb.iead.repository.ProblemaRepository;
import br.org.spb.iead.service.EventoService;
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
public class eventoController {

    @Autowired
    EventoService eventoService;

    @Autowired
    ProblemaRepository problemaRepository;

    @Autowired
    private JavaMailSender mailSender;

    // Configurações do servidor de e-mail obtidas do application.properties
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int porta;

    @Value("${spring.mail.username}")
    private String usuario;

    @Value("${spring.mail.password}")
    private String senha;

    // Configuração do e-mail de destino obtida do application.properties
    @Value("${destinatario.email}")
    private String destinatario;


    @RequestMapping(value = "/eventos",method = RequestMethod.GET)
    public ModelAndView getEventos(){
        ModelAndView mv = new ModelAndView("eventos");
        List<Evento> eventos = eventoService.findAll();
        eventos.sort(Comparator.comparing(Evento::getId, Comparator.reverseOrder()));
        mv.addObject("eventos",eventos);
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
        System.out.println("/eventos/id acessado");
        return mv;
    }


    @RequestMapping(value = "/gerenciar", method = RequestMethod.GET)
    public String getGerentiar(){
        return "gerenciarEventos";
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

        evento.setResolvido("Não Verificado");
        evento.setDataSys(LocalDate.now());

        eventoService.save(evento);

        // Enviar e-mail com os dados do evento
        enviarEmail(evento);

        return "redirect:/";
    }

    @RequestMapping(value = "/eventos/{id}/update", method = RequestMethod.POST)
    public String updateEvento(@PathVariable("id") long id,  @RequestParam("problema.problema") String problema ) {
        Evento evento = eventoService.findById(id);
        Problema problema1 = problemaRepository.findByProblema(problema);

        if(!problema.equals(evento.getProblema().getProblema())){
            evento.setDataClassificacaoUpdate(LocalDate.now());
            evento.setHoraClassificacaoUpdate(LocalTime.now());
            evento.setProblema(problema1);
        }

        evento.setProblema(problema1);
        eventoService.save(evento);
        return "redirect:/eventos/";
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
        return "redirect:/eventos/";
    }


    private void enviarEmail(Evento evento) {
        try {
            // Configurar os detalhes do e-mail
            String assunto = "Novo evento criado - Evn#" + evento.getId();
            String corpo = "Prezado(a) usuário,\n\n" +
                    "Um novo evento foi criado em nosso sistema. Seguem abaixo os detalhes do evento:\n\n" +
                    "Informações do Evento:\n" +
                    "Nome do Colaborador: " + evento.getNomeColaborador() + "\n" +
                    "Data do Evento: " + evento.getData() + "\n" +
                    "Hora do Evento: " + evento.getHora() + "\n" +
                    "Turno: " + evento.getTurno() + "\n" +
                    "Setor de Ocorrência: " + evento.getSetorOcorrencia() + "\n" +
                    "Setor Notificante: " + evento.getSetorNotificante() + "\n" +
                    "Classificação: " + evento.getClassificacao() + "\n\n" +
                    "Descrição do Evento:\n" +
                    evento.getDescricaoEvento() + "\n\n" +
                    "Ação Imediata:\n" +
                    evento.getAcaoImediata() + "\n\n" +
                    "Status do Evento: " + evento.getResolvido() + "\n";

            // Adicione outros detalhes que você deseja incluir no e-mail

            corpo += "\nAtenciosamente,\nEquipe de Informatica";


            // Criar o objeto de e-mail
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(destinatario);
            helper.setSubject(assunto);
            helper.setText(corpo);

            // Enviar o e-mail
            mailSender.send(message);

            System.out.println("E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
    }
