package br.org.spb.iead.repository;

import br.org.spb.iead.model.eventos.TipoEventoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEventoRepository extends JpaRepository<TipoEventoModel, Long> {

    TipoEventoModel findByTipoEvento(String tipoEvento);
}
