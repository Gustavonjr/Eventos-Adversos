package br.org.spb.iead.service;

import br.org.spb.iead.model.RoleModel;

import java.util.List;

public interface RoleService {

    List<RoleModel> findAll();
    RoleModel findById(long id);

}
