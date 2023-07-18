package br.org.spb.iead.service;

import br.org.spb.iead.model.Evento;

import java.util.List;

public interface IeadService {

    List<Evento> findAll();
    Evento findById(long id);
    Evento save(Evento evento);

}
