package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.eventos.ProblemaModel;
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
    public List<ProblemaModel> findAll() {
        return problemaRepository.findAll();
    }

    @Override
    public ProblemaModel findById(long id) {
        return problemaRepository.findById(id).get();
    }

    @Override
    public ProblemaModel save(ProblemaModel problema) {
        return problemaRepository.save(problema);
    }
}
