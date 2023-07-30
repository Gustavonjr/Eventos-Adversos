package br.org.spb.iead.configs;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Autowired
    ConfigService configService;

    @Bean
    @Lazy
    public JavaMailSender getJavaMailSender() {

        Config config = configService.findById(1);

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(config.getHostEmail());
        mailSender.setPort(config.getPortaEmail());

        mailSender.setUsername(config.getUsuarioEmail());
        mailSender.setPassword(config.getSenhaEmail());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
