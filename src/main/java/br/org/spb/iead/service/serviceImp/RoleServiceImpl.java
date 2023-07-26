package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.RoleModel;
import br.org.spb.iead.repository.RoleRepository;
import br.org.spb.iead.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleModel> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleModel findById(long id) {
        return roleRepository.findById(id).get();
    }
}
