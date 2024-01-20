package br.org.spb.iead.service;

import br.org.spb.iead.model.eventos.Evento;

import java.util.List;

public interface EventoService {

    List<Evento> findAll();
    Evento findById(long id);
    Evento save(Evento evento);

}
