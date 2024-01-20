package br.org.spb.iead.service;

import br.org.spb.iead.model.eventos.ObservacaoEvento;

import java.util.List;

public interface ObservacaoEventoService {

    List<ObservacaoEvento> findAll();

    ObservacaoEvento findById(long id);

    ObservacaoEvento save(ObservacaoEvento observacaoEvento);

}
