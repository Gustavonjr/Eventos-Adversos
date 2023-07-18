package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.Setor;
import br.org.spb.iead.repository.setorRepository;
import br.org.spb.iead.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class setorServiceImpl implements SetorService {

    @Autowired
    setorRepository setorRepository;

    @Override
    public List<Setor> findAll() {
        return setorRepository.findAll();
    }

    @Override
    public Setor findById(long id) {
        return setorRepository.findById(id).get();
    }

    @Override
    public Setor save(Setor setor) {
        return setorRepository.save(setor);
    }
}
