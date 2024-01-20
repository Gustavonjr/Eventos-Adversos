package br.org.spb.iead.util;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.model.eventos.Evento;
import br.org.spb.iead.model.eventos.ObservacaoEvento;
import br.org.spb.iead.repository.ConfigRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class EnviarEmail {


    private final JavaMailSender mailSender;


    private final ConfigRepository configRepository;

    private String destinatario;

    public EnviarEmail(JavaMailSender mailSender, ConfigRepository configRepository) {
        this.mailSender = mailSender;
        this.configRepository = configRepository;
        Config config = this.configRepository.findById(1L).get();
        this.destinatario = config.getDestinatariEmail();
    }


    public void enviarEmail(Evento evento, String dest) {
        // Configurar os detalhes do e-mail
        String assunto = "Novo evento criado - Evn#" + evento.getId();
        String corpo = "Prezado(a) usuário,\n\n" +
                "Um novo evento foi criado em nosso sistema. Seguem abaixo os detalhes do evento:\n\n" +
                "Informações do Evento:\n" +
                "Nome do Colaborador: " + evento.getNomeColaborador() + "\n" +
                "Data do Evento: " + evento.getData() + "\n" +
                "Hora do Evento: " + evento.getHora() + "\n" +
                "Turno: " + evento.getTurno() + "\n" +
                "Setor de Ocorrência: " + evento.getSetorOcorrencia().getSetor() + "\n" +
                "Setor Notificante: " + evento.getSetorNotificante().getSetor() + "\n" +
                "Classificação: " + evento.getClassificacao() + "\n\n" +
                "Descrição do Evento:\n" +
                evento.getDescricaoEvento() + "\n\n" +
                "Ação Imediata:\n" +
                evento.getAcaoImediata() + "\n\n" +
                "Status do Evento: " + evento.getResolvido() + "\n";

        if (evento.getObservacao() != null){
            corpo += "\n Observações do evento: \n ";
            List<ObservacaoEvento> obs = evento.getObservacao();
            for (ObservacaoEvento itens: obs ) {
                corpo += "\n - " + itens.getObservacao();
            }
            corpo += "\n ";
        }

        corpo += "\nAtenciosamente,\nEquipe de Qualidade";


        if(dest.isBlank()) {
            Config config = this.configRepository.findById(1L).get();
            this.destinatario = config.getDestinatariEmail();
        }
        else if (!dest.isBlank()) {
            this.destinatario = dest;
        }

        // Criar o objeto de e-mail
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(this.destinatario);
        sm.setText(corpo);
        sm.setSubject(assunto);
        mailSender.send(sm);

        System.out.println("E-mail enviado com sucesso!");
    }
}
