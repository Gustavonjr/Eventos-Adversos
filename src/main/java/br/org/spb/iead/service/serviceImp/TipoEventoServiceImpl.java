package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.eventos.TipoEventoModel;
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
    public List<TipoEventoModel> findAll() {
        return tipoEventoRepository.findAll();
    }

    @Override
    public TipoEventoModel findById(long id) {
        return tipoEventoRepository.findById(id).get();
    }

    @Override
    public TipoEventoModel save(TipoEventoModel tipoEvento) {
        return tipoEventoRepository.save(tipoEvento);
    }

    @Override
    public TipoEventoModel findByTipoEvento(String tipoEvento) {
        return tipoEventoRepository.findByTipoEvento(tipoEvento);
    }
}
