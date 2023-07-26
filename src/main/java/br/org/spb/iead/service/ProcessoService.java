package br.org.spb.iead.service;

import br.org.spb.iead.model.Processo;

import java.util.List;

public interface ProcessoService {

    List<Processo> findAll();
    Processo findByID(long id);
    Processo save(Processo processo);

    Processo findByProcesso(String processo);

}
