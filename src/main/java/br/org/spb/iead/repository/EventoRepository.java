package br.org.spb.iead.repository;

import br.org.spb.iead.model.eventos.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {


}
