package br.org.spb.iead.repository;

import br.org.spb.iead.model.eventos.ProcessoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<ProcessoModel, Long> {

    ProcessoModel findByProcesso(String processo);
}
