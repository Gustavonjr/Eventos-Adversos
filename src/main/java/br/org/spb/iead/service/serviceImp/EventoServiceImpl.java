package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.eventos.Evento;
import br.org.spb.iead.repository.EventoRepository;
import br.org.spb.iead.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll() { return eventoRepository.findAll(); }

    @Override
    public Evento findById(long id) {
        return eventoRepository.findById(id).get();
    }

    @Override
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }



}
