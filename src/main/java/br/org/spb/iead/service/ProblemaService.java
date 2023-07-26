package br.org.spb.iead.service;

import br.org.spb.iead.model.Problema;

import java.util.List;

public interface ProblemaService {

    List<Problema> findAll();
    Problema findById(long id);
    Problema save(Problema problema);


}
