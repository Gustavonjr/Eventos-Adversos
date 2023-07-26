package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.TipoEvento;
import br.org.spb.iead.repository.TipoEventoRepository;
import br.org.spb.iead.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEventoServiceImpl implements TipoEventoService {

   @Autowired
    TipoEventoRepository tipoEventoRepository;

    @Override
    public List<TipoEvento> findAll() {
        return tipoEventoRepository.findAll();
    }

    @Override
    public TipoEvento findById(long id) {
        return tipoEventoRepository.findById(id).get();
    }

    @Override
    public TipoEvento save(TipoEvento tipoEvento) {
        return tipoEventoRepository.save(tipoEvento);
    }

    @Override
    public TipoEvento findByTipoEvento(String tipoEvento) {
        return tipoEventoRepository.findByTipoEvento(tipoEvento);
    }
}
