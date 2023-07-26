package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.Problema;
import br.org.spb.iead.repository.ProblemaRepository;
import br.org.spb.iead.service.ProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProblemaServiceImpl implements ProblemaService {

    @Autowired
    ProblemaRepository problemaRepository;

    @Override
    public List<Problema> findAll() {
        return problemaRepository.findAll();
    }

    @Override
    public Problema findById(long id) {
        return problemaRepository.findById(id).get();
    }

    @Override
    public Problema save(Problema problema) {
        return problemaRepository.save(problema);
    }
}
