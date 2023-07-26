package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.Processo;
import br.org.spb.iead.repository.ProcessoRepository;
import br.org.spb.iead.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessoServiceImpl implements ProcessoService {

    @Autowired
    ProcessoRepository processoRepository;

    @Override
    public List<Processo> findAll() {
        return processoRepository.findAll();
    }

    @Override
    public Processo findByID(long id) {
        return processoRepository.findById(id).get();
    }

    @Override
    public Processo save(Processo processo) {
        return processoRepository.save(processo);
    }

    @Override
    public Processo findByProcesso(String processo) {
        return processoRepository.findByProcesso(processo);
    }
}
