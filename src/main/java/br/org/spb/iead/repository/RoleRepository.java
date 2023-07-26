package br.org.spb.iead.repository;

import br.org.spb.iead.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    RoleModel findByRoleName(String roleName);

}
