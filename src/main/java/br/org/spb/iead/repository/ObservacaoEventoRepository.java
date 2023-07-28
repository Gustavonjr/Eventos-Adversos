package br.org.spb.iead.repository;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.model.ObservacaoEvento;
import br.org.spb.iead.service.ObservacaoEventoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
public interface ObservacaoEventoRepository extends JpaRepository<ObservacaoEvento, Long> {



    List<ObservacaoEvento> findByEventoId(long evento_id);

}
