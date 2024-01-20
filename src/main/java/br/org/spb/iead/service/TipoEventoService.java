package br.org.spb.iead.service;


import br.org.spb.iead.model.eventos.TipoEventoModel;

import java.util.List;

public interface TipoEventoService {

    List<TipoEventoModel> findAll();
    TipoEventoModel findById(long id);
    TipoEventoModel save(TipoEventoModel tipoEvento);

    TipoEventoModel findByTipoEvento(String tipoEvento);
}
