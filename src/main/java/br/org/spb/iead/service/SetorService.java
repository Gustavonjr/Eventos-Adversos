package br.org.spb.iead.service;

import br.org.spb.iead.model.Setor;
import java.util.List;

public interface SetorService {

    List<Setor> findAll();
    Setor findById(long id);
    Setor save(Setor evento);

}
