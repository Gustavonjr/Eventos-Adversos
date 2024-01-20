package br.org.spb.iead.service;

import br.org.spb.iead.model.informatica.ChamadoVivo;

import java.util.List;

public interface ChamadoVivoService {

    List<ChamadoVivo> findAll();
    ChamadoVivo findById(long id);
    ChamadoVivo save(ChamadoVivo chamadoVivo);
}
