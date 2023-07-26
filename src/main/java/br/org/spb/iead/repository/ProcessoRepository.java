package br.org.spb.iead.repository;

import br.org.spb.iead.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

    Processo findByProcesso(String processo);
}
