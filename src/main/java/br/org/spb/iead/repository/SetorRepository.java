package br.org.spb.iead.repository;

import br.org.spb.iead.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    Setor findBySetor(String setor);

}
