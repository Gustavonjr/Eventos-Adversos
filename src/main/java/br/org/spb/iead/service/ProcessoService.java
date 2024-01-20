package br.org.spb.iead.service;

import br.org.spb.iead.model.eventos.ProcessoModel;

import java.util.List;

public interface ProcessoService {

    List<ProcessoModel> findAll();
    ProcessoModel findByID(long id);
    ProcessoModel save(ProcessoModel processo);

    ProcessoModel findByProcesso(String processo);

}
