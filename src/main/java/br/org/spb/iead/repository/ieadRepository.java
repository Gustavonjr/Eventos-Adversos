package br.org.spb.iead.repository;

import br.org.spb.iead.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ieadRepository extends JpaRepository<Evento, Long> {


}
