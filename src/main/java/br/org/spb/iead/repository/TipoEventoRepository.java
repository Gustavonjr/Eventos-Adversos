package br.org.spb.iead.repository;

import br.org.spb.iead.model.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long> {

    TipoEvento findByTipoEvento(String tipoEvento);
}
