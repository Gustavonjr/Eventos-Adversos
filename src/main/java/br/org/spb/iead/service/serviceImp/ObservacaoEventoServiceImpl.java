package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.ObservacaoEvento;
import br.org.spb.iead.repository.ObservacaoEventoRepository;
import br.org.spb.iead.service.ObservacaoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservacaoEventoServiceImpl implements ObservacaoEventoService {

    @Autowired
    ObservacaoEventoRepository observacaoEventoRepository;

    public ObservacaoEventoServiceImpl(){

    }

    @Override
    public List<ObservacaoEvento> findAll() {
        return observacaoEventoRepository.findAll();
    }

    @Override
    public ObservacaoEvento findById(long id) {
        return observacaoEventoRepository.findById(id).get();
    }

    @Override
    public ObservacaoEvento save(ObservacaoEvento observacaoEvento) {
        return observacaoEventoRepository.save(observacaoEvento);
    }
}
