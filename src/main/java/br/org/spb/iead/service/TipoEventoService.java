package br.org.spb.iead.service;


import br.org.spb.iead.model.TipoEvento;

import java.util.List;

public interface TipoEventoService {

    List<TipoEvento> findAll();
    TipoEvento findById(long id);
    TipoEvento save(TipoEvento tipoEvento);

    TipoEvento findByTipoEvento(String tipoEvento);
}
