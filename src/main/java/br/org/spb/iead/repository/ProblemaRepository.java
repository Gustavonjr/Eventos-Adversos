package br.org.spb.iead.repository;

import br.org.spb.iead.model.eventos.ProblemaModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProblemaRepository extends JpaRepository<ProblemaModel, Long> {

    ProblemaModel findByProblema(String problema);

}
