package br.org.spb.iead.repository;

import br.org.spb.iead.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventoRepository extends JpaRepository<Evento, Long> {


}
