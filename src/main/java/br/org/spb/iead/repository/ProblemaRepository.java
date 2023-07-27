package br.org.spb.iead.repository;

import br.org.spb.iead.model.Problema;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProblemaRepository extends JpaRepository<Problema, Long> {

    Problema findByProblema(String problema);

}
