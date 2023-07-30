package br.org.spb.iead.repository;

import br.org.spb.iead.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, Long> {
}
