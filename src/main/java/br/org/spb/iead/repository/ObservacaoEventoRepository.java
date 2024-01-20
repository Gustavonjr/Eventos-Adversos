package br.org.spb.iead.repository;

import br.org.spb.iead.model.eventos.ObservacaoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservacaoEventoRepository extends JpaRepository<ObservacaoEvento, Long> {



    List<ObservacaoEvento> findByEventoId(long evento_id);

}
