package br.org.spb.iead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class IncidentesEEventosAdversosApplication {

	public static void main(String[] args) {
				SpringApplication.run(IncidentesEEventosAdversosApplication.class, args);

		//System.out.println(new BCryptPasswordEncoder().encode("admin"));
		System.out.println("Bem vindo!");
	}

}
