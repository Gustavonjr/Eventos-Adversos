package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.SetorModel;
import br.org.spb.iead.repository.SetorRepository;
import br.org.spb.iead.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorServiceImpl implements SetorService {

    @Autowired
    SetorRepository setorRepository;

    @Override
    public List<SetorModel> findAll() {
        return setorRepository.findAll();
    }

    @Override
    public SetorModel findById(long id) {
        return setorRepository.findById(id).get();
    }

    @Override
    public SetorModel save(SetorModel setor) {
        return setorRepository.save(setor);
    }
}
