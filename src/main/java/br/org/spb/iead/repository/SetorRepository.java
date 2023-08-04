package br.org.spb.iead.repository;

import br.org.spb.iead.model.SetorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<SetorModel, Long> {

    SetorModel findBySetor(String nome);

}
