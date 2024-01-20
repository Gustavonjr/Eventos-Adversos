package br.org.spb.iead.service;

import br.org.spb.iead.model.eventos.ProblemaModel;

import java.util.List;

public interface ProblemaService {

    List<ProblemaModel> findAll();
    ProblemaModel findById(long id);
    ProblemaModel save(ProblemaModel problema);


}
