package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.repository.eventoRepository;
import br.org.spb.iead.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class eventoServiceImpl implements EventoService {

    @Autowired
    eventoRepository ieadRep;

    @Override
    public List<Evento> findAll() { return ieadRep.findAll(); }

    @Override
    public Evento findById(long id) {
        return ieadRep.findById(id).get();
    }

    @Override
    public Evento save(Evento evento) {
        return ieadRep.save(evento);
    }

}
